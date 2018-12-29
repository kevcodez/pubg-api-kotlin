package de.kevcodez.pubg.model.telemetry.events

import de.kevcodez.pubg.model.telemetry.objects.Character

class RedZoneEnded : TelemetryEvent() {
    lateinit var drivers: List<Character>
}