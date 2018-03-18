package de.kevcodez.pubg.client

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import de.kevcodez.pubg.exception.ApiException
import de.kevcodez.pubg.model.Match
import de.kevcodez.pubg.model.Region
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import org.slf4j.LoggerFactory

class ApiClient(private val apiKey: String, private val httpClient: OkHttpClient) {

    private val objectMapper: ObjectMapper = ObjectMapper().registerModule(KotlinModule())

    fun getMatch(region: Region, id: String): Match {
        val urlBuilder = HttpUrl.Builder()
            .scheme(API_SCHEME)
            .host(API_HOST)
            .addPathSegment("shards")
            .addPathSegment(region.toString())
            .addPathSegment("matches")
            .addPathSegment(id)

        val request = buildRequest(urlBuilder.build())

        val response = httpClient.newCall(request).execute()
        if (response.code() != 200) {
            throw ApiException(response)
        }

        return objectMapper.readValue(response.body()!!.string(), Match::class.java)
    }

    fun getMatches(
        region: Region,
        offset: Int? = 0,
        limit: Int? = 5,
        sort: MatchSortBy? = MatchSortBy.CREATED_AT_ASCENDING,
        filter: MatchFilter? = null
    ): List<Match> {
        if (limit != null && (limit < 0 || limit > 5))
            LOG.warn("Limit should be within 1-5")

        var urlBuilder = HttpUrl.Builder()
            .scheme(API_SCHEME)
            .host(API_HOST)
            .addPathSegment("shards")
            .addPathSegment(region.toString())
            .addPathSegment("matches")

        if (offset != null)
            urlBuilder = urlBuilder.addQueryParameter("page[offset]", offset.toString())

        if (limit != null)
            urlBuilder = urlBuilder.addQueryParameter("page[limit]", limit.toString())

        if (sort != null)
            urlBuilder = urlBuilder.addQueryParameter("sort", sort.parameter)

        if (filter != null) {
            with(filter) {
                if (filterCreatedAtStart != null)
                    urlBuilder = urlBuilder.addQueryParameter("filter[createdAt-start]", filterCreatedAtStart)

                if (filterCreatedAtEnd != null)
                    urlBuilder = urlBuilder.addQueryParameter("filter[createdAt-end]", filterCreatedAtEnd)

                if (filterPlayerIds != null)
                    urlBuilder = urlBuilder.addQueryParameter("filter[playerIds]", filterPlayerIds.joinToString())

                if (filterGameMode != null)
                    urlBuilder = urlBuilder.addQueryParameter("filter[gameMode]", filterGameMode.joinToString())
            }
        }

        val request = buildRequest(urlBuilder.build())

        val response = httpClient.newCall(request).execute()
        if (response.code() != 200) {
            throw ApiException(response)
        }

        return objectMapper.readValue(response.body()!!.string(), object : TypeReference<List<Match>>() {
        })
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