package de.kevcodez.pubg.model.telemetry.events

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import de.kevcodez.pubg.model.telemetry.objects.Character

@JsonIgnoreProperties(ignoreUnknown = true)
class MatchStart : TelemetryEvent() {

    lateinit var characters: List<Character>
    lateinit var mapName: String
    lateinit var weatherId: String
    lateinit var cameraViewBehaviour: String
    var teamSize: Int = 0

    // FIXME
    //lateinit var blueZoneCustomOptions: List<BlueZoneCustomOption>

}