package de.kevcodez.pubg.model.player

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import de.kevcodez.pubg.model.Link

@JsonIgnoreProperties("meta")
data class PlayerResponse(
    @JsonProperty("data")
    val player: PlayerType,
    val links: Link
)
