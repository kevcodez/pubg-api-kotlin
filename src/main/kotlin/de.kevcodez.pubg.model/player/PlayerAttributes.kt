package de.kevcodez.pubg.model.player

import java.time.Instant

data class PlayerAttributes(
    val createdAt: Instant,
    val updatedAt: Instant,
    /** Player name */
    val name: String,
    /** Stats particular to players */
    val stats: Any?,
    /** Identifies the studio and game */
    val titleId: String,
    /** Platform-region shard */
    val shardId: String,
    /** Version of the game */
    val patchVersion: String
)

