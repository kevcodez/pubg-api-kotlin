package de.kevcodez.pubg.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

/**
 * Match records are created every time players complete a game session. Each match contains high level information about the game session, i.e. gameMode, etc.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
data class Match (
    val id: String,
    val createdAt: String,
    val duration: Int,
    val rosters: List<Roster>,
    val rounds: Any,
    val assets: List<Asset>,
    val spectators: Any,
    val stats: Any,
    val gameMode: String,
    val patchVersion: String,
    val titleId: String,
    val shardId: String,
    val tags: Any
)