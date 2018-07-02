package de.kevcodez.pubg.model.telemetry.events

import de.kevcodez.pubg.model.telemetry.objects.Character

class SwimStart : TelemetryEvent() {
    lateinit var character: Character
}