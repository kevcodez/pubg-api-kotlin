package de.kevcodez.pubg.model.season

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class PlayerSeasonResponse (
    @JsonProperty("data")
    val season: PlayerSeason
)