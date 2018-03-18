package de.kevcodez.pubg.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Participant (
    val id: String,
    val stats: Any,
    val actor: String,
    val shardId: String
)
