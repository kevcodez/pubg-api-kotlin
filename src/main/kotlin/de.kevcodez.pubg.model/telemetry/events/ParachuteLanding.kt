package de.kevcodez.pubg.model.telemetry.events

import de.kevcodez.pubg.model.telemetry.objects.Character

class ParachuteLanding : TelemetryEvent() {
    lateinit var character: Character
    var distance: Float = 0.0F
}