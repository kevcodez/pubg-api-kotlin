package de.kevcodez.pubg.client

data class MatchFilter(
    val filterCreatedAtStart: String? = null,
    val filterCreatedAtEnd: String? = null,
    val filterPlayerIds: List<String>? = null,
    val filterGameMode: List<String>? = null
)