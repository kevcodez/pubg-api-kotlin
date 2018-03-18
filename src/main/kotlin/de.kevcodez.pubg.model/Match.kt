package de.kevcodez.pubg.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

/**
 * Match records are created every time players complete a game session. Each match contains high level information about the game session, i.e. gameMode, etc.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
data class Match (
    /** Match ID */
    val id: String,
    /** Time of match completion */
    val createdAt: String,
    val duration: Int,
    val rosters: List<Roster>,
    val rounds: Any,
    val assets: List<Asset>,
    val spectators: Any,
    /** Stats particular to matches */
    val stats: Any,
    /** Game mode played */
    val gameMode: String,
    val patchVersion: String,
    /** Identifies the studio and game */
    val titleId: String,
    /** Platform-region shard */
    val shardId: String,
    /** Searchable tags */
    val tags: Any
)