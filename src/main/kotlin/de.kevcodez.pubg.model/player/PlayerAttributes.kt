package de.kevcodez.pubg.model.player

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.time.Instant

@JsonIgnoreProperties(ignoreUnknown = true)
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
