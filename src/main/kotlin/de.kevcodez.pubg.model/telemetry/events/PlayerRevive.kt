package de.kevcodez.pubg.model.telemetry.events

import de.kevcodez.pubg.model.telemetry.objects.Character

class PlayerRevive : TelemetryEvent() {
    lateinit var reviver: Character
    lateinit var victim: Character
}