package de.kevcodez.pubg.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

/**
 * Rosters track the scores of each opposing group of participants.
 * Rosters can have one or many participants depending on the game mode.
 * Roster objects are only meaningful within the context of a match and are not exposed as a standalone resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
data class Roster(
    val id: String,
    val team: Any,
    val participants: List<Participant>,
    /** Stats particular to rosters */
    val stats: Any,
    /** Indicates if this roster won the match */
    val won: String,
    /** Platform-region Shard */
    val shardId: String
)