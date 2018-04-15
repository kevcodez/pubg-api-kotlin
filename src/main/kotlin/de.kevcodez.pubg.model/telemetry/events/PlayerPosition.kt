package de.kevcodez.pubg.model.telemetry.events

import de.kevcodez.pubg.model.telemetry.objects.Character

class PlayerPosition : TelemetryEvent() {
    lateinit var character: Character
    var elapsedTime: Float = 0.0F
    var numAlivePlayers: Int = 0
}