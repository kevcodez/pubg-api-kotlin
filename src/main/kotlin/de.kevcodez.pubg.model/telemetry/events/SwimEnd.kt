package de.kevcodez.pubg.model.telemetry.events

import de.kevcodez.pubg.model.telemetry.objects.Character

class SwimEnd : TelemetryEvent() {
    lateinit var character: Character
    var swimDistance: Float? = null
}