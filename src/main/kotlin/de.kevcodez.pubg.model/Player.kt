package de.kevcodez.pubg.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

/**
 * Player objects contain aggregated lifetime information about each player.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
data class Player(
    /** Player ID */
    val id: String,
    /** Player name */
    val Name: String,
    /** Stats particular to players */
    val Stats: Any,
    /** Identifies the studio and game */
    val titleId: String,
    /** Platform-region shard */
    val shardId: String,
    val createdAt: String,
    val assets: List<Asset>,
    /** Version of the game */
    val patchVersion: String
)