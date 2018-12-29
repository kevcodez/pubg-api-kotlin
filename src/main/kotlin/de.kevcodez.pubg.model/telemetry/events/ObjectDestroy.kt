package de.kevcodez.pubg.model.telemetry.events

import de.kevcodez.pubg.model.telemetry.objects.Character
import de.kevcodez.pubg.model.telemetry.objects.Location

class ObjectDestroy : TelemetryEvent() {
    lateinit var character: Character
    lateinit var objectType: String
    lateinit var objectLocation: Location
}