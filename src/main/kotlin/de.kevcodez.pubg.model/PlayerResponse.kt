package de.kevcodez.pubg.model

import com.fasterxml.jackson.annotation.JsonProperty

data class PlayerResponse(
    @JsonProperty("data")
    val players: List<PlayerType>,
    val links: Link,
    val meta: Any
)



