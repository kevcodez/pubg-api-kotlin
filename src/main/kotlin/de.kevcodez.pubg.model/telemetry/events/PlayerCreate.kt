package de.kevcodez.pubg.model.telemetry.events

import de.kevcodez.pubg.model.telemetry.objects.Character

class PlayerCreate : TelemetryEvent() {
    lateinit var character: Character
}