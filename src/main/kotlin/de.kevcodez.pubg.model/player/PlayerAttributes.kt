package de.kevcodez.pubg.model.player

data class PlayerAttributes(
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

