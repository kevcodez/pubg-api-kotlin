package de.kevcodez.pubg.model.telemetry.events

import de.kevcodez.pubg.model.telemetry.objects.Character

class VaultStart : TelemetryEvent() {
    lateinit var character: Character
}