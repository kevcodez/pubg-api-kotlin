package de.kevcodez.pubg.model.telemetry.events

import com.fasterxml.jackson.annotation.JsonProperty

class MatchDefinition : TelemetryEvent() {
    @JsonProperty("MatchId")
    var matchId: String = ""
    @JsonProperty("PingQuality")
    var pingQuality: String? = null
}