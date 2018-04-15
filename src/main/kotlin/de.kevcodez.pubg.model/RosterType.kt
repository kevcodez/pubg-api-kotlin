package de.kevcodez.pubg.model

class RosterType : ObjectWithType() {
    lateinit var stats: RosterStats
    lateinit var id: String

    lateinit var relationships: Relationships
    lateinit var attributes: RosterAttributes
}

data class RosterAttributes(
    val stats: RosterStats,
    val shardId: String,
    val won: Boolean
)

data class RosterStats(
    val rank: Int,
    val teamId: Int
)

