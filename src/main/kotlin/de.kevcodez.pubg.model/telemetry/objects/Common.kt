package de.kevcodez.pubg.model.telemetry.objects

import com.fasterxml.jackson.annotation.JsonProperty

data class Common(
    @JsonProperty("isGame")
    val isGame: Float
)
