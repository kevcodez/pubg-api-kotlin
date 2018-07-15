package de.kevcodez.pubg.client

data class PlayerFilter(
    val playerIds: List<String> = emptyList(),
    val playerNames: List<String> = emptyList()
)
