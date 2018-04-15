package de.kevcodez.pubg.model

data class MatchResponse(
    val data: MatchData,
    val included: List<ObjectWithType>,
    val links: Link,
    val meta: Any
)

data class MatchData(
    val type: String,
    val id: String,
    val attributes: MatchAttributes,
    val links: Link,
    val relationships: Relationships
)

data class MatchAttributes(
    val createdAt: String,
    val duration: Int,
    val gameMode: String,
    val mapName: String,
    val shardId: String,
    val stats: Any?,
    val tags: Any?,
    val titleId: String
)
