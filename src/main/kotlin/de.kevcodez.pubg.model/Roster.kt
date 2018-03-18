package de.kevcodez.pubg.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Roster(
    val id: String,
    val team: Any,
    val participants: List<Participant>,
    val stats: Any,
    val won: String,
    val shardId: String
)