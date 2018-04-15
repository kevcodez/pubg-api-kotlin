package de.kevcodez.pubg.client

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import de.kevcodez.pubg.exception.ApiException
import de.kevcodez.pubg.model.MatchResponse
import de.kevcodez.pubg.model.PlayerResponse
import de.kevcodez.pubg.model.Region
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import org.slf4j.LoggerFactory
import java.nio.charset.StandardCharsets

class ApiClient(private val apiKey: String, private val httpClient: OkHttpClient) {

    private val objectMapper: ObjectMapper = ObjectMapper().registerModule(KotlinModule())

    fun getPlayer(region: Region, id: String) : PlayerResponse {
        val urlBuilder = HttpUrl.Builder()
            .scheme(API_SCHEME)
            .host(API_HOST)
            .addPathSegment("shards")
            .addPathSegment(region.identifier)
            .addPathSegment("players")
            .addPathSegment(id)

        val request = buildRequest(urlBuilder.build())

        val response = httpClient.newCall(request).execute()
        if (response.code() != 200) {
            throw ApiException(response)
        }

        return objectMapper.readValue(response.body()!!.string(), PlayerResponse::class.java)
    }

    fun getPlayers(region: Region, playerFilter: PlayerFilter) : PlayerResponse {
        var urlBuilder = HttpUrl.Builder()
            .scheme(API_SCHEME)
            .host(API_HOST)
            .addPathSegment("shards")
            .addPathSegment(region.identifier)
            .addPathSegment("players")

        if (playerFilter.playerIds.isNotEmpty())
            urlBuilder = urlBuilder.addEncodedQueryParameter("filter[playerIds]", playerFilter.playerIds.joinToString())

        if (playerFilter.playerNames.isNotEmpty())
            urlBuilder =  urlBuilder.addEncodedQueryParameter("filter[playerNames]", playerFilter.playerNames.joinToString())


        val request = buildRequest(urlBuilder.build())

        val response = httpClient.newCall(request).execute()
        if (response.code() != 200) {
            throw ApiException(response)
        }

        val bytes = response.body()!!.bytes()
        return objectMapper.readValue(String(bytes, StandardCharsets.UTF_8), PlayerResponse::class.java)
    }

    data class PlayerFilter(
        val playerIds: List<String> = emptyList(),
        val playerNames: List<String> = emptyList()
    )

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

        return objectMapper.readValue(response.body()!!.string(), MatchResponse::class.java)
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