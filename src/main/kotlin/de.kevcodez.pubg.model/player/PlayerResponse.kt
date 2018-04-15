package de.kevcodez.pubg.model.player

import com.fasterxml.jackson.annotation.JsonProperty
import de.kevcodez.pubg.model.Link

data class PlayerResponse(
    @JsonProperty("data")
    val players: List<PlayerType>,
    val links: Link,
    val meta: Any
)



