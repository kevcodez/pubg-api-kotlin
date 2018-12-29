package de.kevcodez.pubg.model.telemetry.objects

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class GameResult(
    val rank: Int,
    val gameResult: String,
    val teamId: Int,
    val stats: Stats,
    val accountId: String
)