package de.kevcodez.pubg.client

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinModule
import de.kevcodez.pubg.exception.ApiException
import de.kevcodez.pubg.model.Region
import de.kevcodez.pubg.model.match.MatchResponse
import de.kevcodez.pubg.model.player.PlayerResponse
import de.kevcodez.pubg.model.player.PlayersResponse
import de.kevcodez.pubg.model.season.Season
import de.kevcodez.pubg.model.season.SeasonResponse
import de.kevcodez.pubg.model.status.Status
import de.kevcodez.pubg.model.telemetry.events.TelemetryEvent
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import org.slf4j.LoggerFactory

class ApiClient(private val apiKey: String, private val httpClient: OkHttpClient) {

    private val objectMapper: ObjectMapper = ObjectMapper()
        .registerModule(KotlinModule())
        .registerModule(JavaTimeModule())
        .enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)

    fun getPlayer(region: Region, id: String, season: String? = null): PlayerResponse {
        var urlBuilder = HttpUrl.Builder()
            .scheme(API_SCHEME)
            .host(API_HOST)
            .addPathSegment("shards")
            .addPathSegment(region.identifier)
            .addPathSegment("players")
            .addPathSegment(id)

        if (season != null)
            urlBuilder = urlBuilder.addPathSegment("seasons").addPathSegment(season)

        val request = buildRequest(urlBuilder.build())

        val response = httpClient.newCall(request).execute()
        if (response.code() != 200) {
            throw ApiException(response)
        }

        return objectMapper.readValue(response.body()!!.string(), PlayerResponse::class.java)
    }

    fun getPlayers(region: Region, playerFilter: PlayerFilter): PlayersResponse {
        var urlBuilder = HttpUrl.Builder()
            .scheme(API_SCHEME)
            .host(API_HOST)
            .addPathSegment("shards")
            .addPathSegment(region.identifier)
            .addPathSegment("players")

        if (playerFilter.playerIds.isNotEmpty())
            urlBuilder = urlBuilder.addEncodedQueryParameter("filter[playerIds]", playerFilter.playerIds.joinToString(","))

        if (playerFilter.playerNames.isNotEmpty())
            urlBuilder = urlBuilder.addEncodedQueryParameter("filter[playerNames]", playerFilter.playerNames.joinToString(","))


        val request = buildRequest(urlBuilder.build())

        val response = httpClient.newCall(request).execute()
        if (response.code() != 200) {
            throw ApiException(response)
        }

        val bodyAsString = response.body()!!.string()
        return objectMapper.readValue(bodyAsString, PlayersResponse::class.java)
    }

    fun getMatch(region: Region, id: String): MatchResponse {
        val urlBuilder = HttpUrl.Builder()
            .scheme(API_SCHEME)
            .host(API_HOST)
            .addPathSegment("shards")
            .addPathSegment(region.identifier)
            .addPathSegment("matches")
            .addPathSegment(id)

        val request = buildRequest(urlBuilder.build())

        val response = httpClient.newCall(request).execute()
        if (response.code() != 200) {
            throw ApiException(response)
        }

        val bodyAsString = response.body()!!.string()
        return objectMapper.readValue(bodyAsString, MatchResponse::class.java)
    }

    fun getTelemetryData(URL: String): List<TelemetryEvent> {
        val httpUrl = HttpUrl.parse(URL)!!

        val request = buildRequest(httpUrl)

        val response = httpClient.newCall(request).execute()
        if (response.code() != 200) {
            throw ApiException(response)
        }

        return objectMapper.readValue(response.body()!!.string(), object : TypeReference<List<TelemetryEvent>>() {})
    }

    fun getSeasons(region: Region): SeasonResponse {
        val urlBuilder = HttpUrl.Builder()
            .scheme(API_SCHEME)
            .host(API_HOST)
            .addPathSegment("shards")
            .addPathSegment(region.identifier)
            .addPathSegment("seasons")

        val request = buildRequest(urlBuilder.build())

        val response = httpClient.newCall(request).execute()
        if (response.code() != 200) {
            throw ApiException(response)
        }

        val bodyAsString = response.body()!!.string()
        return objectMapper.readValue(bodyAsString, SeasonResponse::class.java)
    }

    fun getStatus(): Status {
        val urlBuilder = HttpUrl.Builder()
            .scheme(API_SCHEME)
            .host(API_HOST)
            .addPathSegment("status")

        val request = buildRequest(urlBuilder.build())

        val response = httpClient.newCall(request).execute()
        if (response.code() != 200) {
            throw ApiException(response)
        }

        return objectMapper.readValue(response.body()!!.string(), Status::class.java)
    }

    private fun buildRequest(url: HttpUrl): Request {
        return Request.Builder()
            .url(url)
            .addHeader("Authorization", "Bearer $apiKey")
            .addHeader("Accept", "application/vnd.api+json")
            .build()
    }

    companion object {

        private val LOG = LoggerFactory.getLogger(ApiClient::class.java)

        private const val API_SCHEME = "https"
        private const val API_HOST = "api.playbattlegrounds.com"
    }

}