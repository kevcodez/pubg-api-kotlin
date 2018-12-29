package de.kevcodez.pubg.client

import de.kevcodez.pubg.model.Platform
import io.mockk.every
import io.mockk.mockk
import okhttp3.*
import org.junit.jupiter.api.Test

class ApiClientTest {

    private val httpClient: OkHttpClient = mockk()
    private val apiKey = "API-KEY"

    private val apiClient = ApiClient(apiKey, httpClient)

    @Test
    fun getMatch() {
        mockResponse("/examples/match.json")
        val matchResponse = apiClient.getMatch(Platform.STEAM, "id")

        // TODO proper assertions
    }

    @Test
    fun getPlayer() {
        mockResponse("/examples/player.json")
        val playerResponse = apiClient.getPlayer(platform = Platform.STEAM, id = "foo")

        // TODO proper assertions
    }

    @Test
    fun getPlayers() {
        mockResponse("/examples/players.json")
        val playersResponse = apiClient.getPlayers(platform = Platform.STEAM, playerFilter = PlayerFilter())

        // TODO proper assertions
    }

    @Test
    fun getTelemetry() {
        mockResponse("/examples/telemetry.json")
        val telemetryEvents =
            apiClient.getTelemetryData("https://telemetry-cdn.playbattlegrounds.com/pc-krjp/2018/01/01/0/0/1ad97f85-cf9b-11e7-b84e-0a586460f004-telemetry.json")

        // TODO proper assertions
    }

    @Test
    fun getSeasons() {
        mockResponse("/examples/seasons.json")
        val seasons = apiClient.getSeasons(Platform.STEAM)

        // TODO proper assertions
    }

    @Test
    fun getPlayerSeason() {
        mockResponse("/examples/playerseason.json")
        val seasons = apiClient.getSeason(Platform.STEAM, "accountId", "seasonId")

        // TODO proper assertions
    }


    @Test
    fun getTournaments() {
        mockResponse("/examples/tournaments.json")
        val tournaments = apiClient.getTournaments()

        // TODO assertions
    }

    @Test
    fun getTournmanet() {
        mockResponse("/examples/tournament.json")
        val tournament = apiClient.getTournament("123")

        // TODO assertions
    }

    @Test
    fun getStatus() {
        mockResponse("/examples/status.json")
        val status = apiClient.isStatusOk()

        // TODO proper assertions
    }

    private fun mockResponse(resource: String) {
        val text = ApiClientTest::class.java.getResource(resource).readText()
        val mockedResponse: Response = mockk()
        every { mockedResponse.isSuccessful } returns true
        every { mockedResponse.body() } returns
                ResponseBody.create(
                    MediaType.parse("application/json"),
                    text
                )

        val mockedCall: Call = mockk()
        every { httpClient.newCall(any()) } returns mockedCall
        every { mockedCall.execute() } returns mockedResponse
    }
}
