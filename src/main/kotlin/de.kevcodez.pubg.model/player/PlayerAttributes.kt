package de.kevcodez.pubg.model.player

import java.time.Instant

data class PlayerAttributes(
    /** Player name */
    val name: String,
    /** Identifies the studio and game */
    val stats: Any?,
    val titleId: String,
    /** Platform-region shard */
    val shardId: String,
    val createdAt: Instant?,
    val updatedAt: Instant?,
    /** Version of the game */
    val patchVersion: String
)