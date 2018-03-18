package de.kevcodez.pubg.client

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import de.kevcodez.pubg.model.Region
import okhttp3.*
import org.junit.jupiter.api.Test

class ApiClientTest {

    private val httpClient: OkHttpClient = mock()
    private val apiKey = "API-KEY"

    private val apiClient = ApiClient(apiKey, httpClient)

    @Test
    fun getMatch() {
        mockResponse("/examples/match.json")
        val match = apiClient.getMatch(Region.PC_ASIA, "id")

        // TODO assertions
    }

    @Test
    fun getMatches() {
        mockResponse("/examples/matches.json")
        val matches = apiClient.getMatches(region = Region.PC_ASIA)

        // TODO assertions
    }

    private fun mockResponse(resource: String) {
        val mockedResponse: Response = mock()
        whenever(mockedResponse.code()).thenReturn(200)
        whenever(mockedResponse.body()).thenReturn(
            ResponseBody.create(
                MediaType.parse("application/json"),
                ApiClientTest::class.java.getResource(resource).readText()
            )
        )
        val mockedCall: Call = mock()
        whenever(httpClient.newCall(any())).thenReturn(mockedCall)
        whenever(mockedCall.execute()).thenReturn(mockedResponse)
    }
}