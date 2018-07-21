package de.kevcodez.pubg.model.telemetry.objects

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Common(
    @JsonProperty("isGame")
    val isGame: Float
)
