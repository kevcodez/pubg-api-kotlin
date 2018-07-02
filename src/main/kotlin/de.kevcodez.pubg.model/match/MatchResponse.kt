package de.kevcodez.pubg.model.match

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import de.kevcodez.pubg.model.Link
import de.kevcodez.pubg.model.Relationships
import java.time.Instant

data class MatchResponse(
    val data: MatchData,
    val included: List<MatchObject>,
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

@JsonIgnoreProperties("stats", "tags")
data class MatchAttributes(
    val createdAt: Instant,
    val duration: Int,
    val gameMode: String,
    val mapName: String,
    val shardId: String,
    val titleId: String,
    val isCustomMatch: Boolean = false
)
