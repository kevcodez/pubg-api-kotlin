package de.kevcodez.pubg.model.season

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.node.ArrayNode

@JsonIgnoreProperties(ignoreUnknown = true)
data class PlayerSeason(

    @JsonProperty("attributes")
    val attributes: SeasonAttributes,

    @JsonProperty("relationships")
    val relationships: SeasonRelationships
)

data class SeasonAttributes(
    val gameModeStats: GameModeStats
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class GameModeStats(

    @JsonProperty("duo")
    val duo: PlayerSeasonStats,

    @JsonProperty("duo-fpp")
    val duoFpp: PlayerSeasonStats,

    @JsonProperty("solo")
    val solo: PlayerSeasonStats,

    @JsonProperty("solo-fpp")
    val soloFpp: PlayerSeasonStats,

    @JsonProperty("squad")
    val squad: PlayerSeasonStats,

    @JsonProperty("squad-fpp")
    val squadFpp: PlayerSeasonStats

)

@JsonIgnoreProperties(ignoreUnknown = true)
class SeasonRelationships {

    lateinit var matchesDuo: List<String>
    lateinit var matchesDuoFpp: List<String>
    lateinit var matchesSolo: List<String>
    lateinit var matchesSoloFpp: List<String>
    lateinit var matchesSquad: List<String>
    lateinit var matchesSquadFpp: List<String>
    lateinit var seasonId: String
    lateinit var playerId: String

    @JsonProperty("matchesSolo")
    private fun unpackMatchesSolo(matches: JsonNode) {
        val data = matches.get("data") as ArrayNode

        matchesSolo = data.map { it.get("id").textValue() }.toList()
    }

    @JsonProperty("matchesSoloFPP")
    private fun unpackMatchesSoloFpp(matches: JsonNode) {
        val data = matches.get("data") as ArrayNode

        matchesSoloFpp = data.map { it.get("id").textValue() }.toList()
    }

    @JsonProperty("matchesDuo")
    private fun unpackMatchesDuo(matches: JsonNode) {
        val data = matches.get("data") as ArrayNode

        matchesDuo = data.map { it.get("id").textValue() }.toList()
    }

    @JsonProperty("matchesDuoFPP")
    private fun unpackMatchesDuoFpp(matches: JsonNode) {
        val data = matches.get("data") as ArrayNode

        matchesDuoFpp = data.map { it.get("id").textValue() }.toList()
    }

    @JsonProperty("matchesSquad")
    private fun unpackMatchesSquad(matches: JsonNode) {
        val data = matches.get("data") as ArrayNode

        matchesSquad = data.map { it.get("id").textValue() }.toList()
    }

    @JsonProperty("matchesSquadFPP")
    private fun unpackMatchesSquadFpp(matches: JsonNode) {
        val data = matches.get("data") as ArrayNode

        matchesSquadFpp = data.map { it.get("id").textValue() }.toList()
    }

    @JsonProperty("player")
    private fun unpackPlayerId(player: JsonNode) {
        playerId = player.get("data").get("id").textValue()
    }

    @JsonProperty("season")
    private fun unpackSeasonId(season: JsonNode) {
        seasonId = season.get("data").get("id").textValue()
    }

}

@JsonIgnoreProperties(ignoreUnknown = true)
data class PlayerSeasonStats(
    val assists: Int,
    val bestRankPoint: Double,
    val boosts: Int,
    val dBNOs: Double,
    val dailyKills: Int,
    val dailyWins: Int,
    val damageDealt: Double,
    val days: Int,
    val headshotKills: Int,
    val heals: Int,
    val killPoints: Double,
    val kills: Int,
    val longestKill: Double,
    val longestTimeSurvived: Double,
    val losses: Int,
    val maxKillStreaks: Int,
    val mostSurvivalTime: Double,
    val rankPoints: Double,
    val revives: Int,
    val rideDistance: Double,
    val roadKills: Int,
    val roundMostKills: Int,
    val roundsPlayed: Int,
    val suicides: Int,
    val swimDistance: Double,
    val teamKills: Int,
    val timeSurvived: Double,
    val top10s: Int,
    val vehicleDestroys: Int,
    val walkDistance: Double,
    val weaponsAcquired: Int,
    val weeklyKills: Int,
    val weeklyWins: Int,
    val winPoints: Double,
    val wins: Int
)