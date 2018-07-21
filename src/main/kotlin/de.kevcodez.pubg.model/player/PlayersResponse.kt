package de.kevcodez.pubg.model.player

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import de.kevcodez.pubg.model.Link

@JsonIgnoreProperties(ignoreUnknown = true)
data class PlayersResponse(
    @JsonProperty("data")
    val player: List<PlayerType>,
    val links: Link
)
