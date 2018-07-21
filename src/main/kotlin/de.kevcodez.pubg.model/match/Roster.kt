package de.kevcodez.pubg.model.match

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import de.kevcodez.pubg.model.Relationships

class Roster : MatchObject() {

    lateinit var id: String
    lateinit var relationships: Relationships
    lateinit var attributes: RosterAttributes

}

@JsonIgnoreProperties(ignoreUnknown = true)
data class RosterAttributes(
    val stats: RosterStats,
    val shardId: String,
    val won: Boolean
)

data class RosterStats(
    val rank: Int,
    val teamId: Int
)
