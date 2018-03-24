package de.kevcodez.pubg.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

/**
 * Participant objects represent each player in the context of a match.
 * Each participant will have a single player relationship which can be used to locate the player's aggregated liftime stats.
 * Participant objects are only meaningful within the context of a match and are not exposed as a standalone resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
data class Participant(
    /** Participant ID */
    val id: String,
    /** Stats particular to participants */
    val stats: ParticipantStats,
    val actor: String,
    /** Platform-region shard */
    val shardId: String
)
