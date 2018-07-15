package de.kevcodez.pubg.model.telemetry.events

import de.kevcodez.pubg.model.telemetry.objects.Character

class MatchEnd : TelemetryEvent() {
    lateinit var characters: List<Character>
}
