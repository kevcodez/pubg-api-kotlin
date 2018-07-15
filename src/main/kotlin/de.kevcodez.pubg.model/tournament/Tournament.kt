package de.kevcodez.pubg.model.tournament

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.time.Instant

@JsonIgnoreProperties(ignoreUnknown = true)
data class Tournament(
    val id: String,
    val attributes: TournamentAttributes?
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class TournamentAttributes(
    val createdAt: Instant
)
