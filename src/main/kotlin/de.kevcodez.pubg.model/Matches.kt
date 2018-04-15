package de.kevcodez.pubg.model

data class Matches(
    val data: List<Match>
)

data class Match(
    val type: String,
    val id: String
)