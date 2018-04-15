package de.kevcodez.pubg.model.telemetry.events

import de.kevcodez.pubg.model.telemetry.objects.Character
import de.kevcodez.pubg.model.telemetry.objects.Item

class ItemDetach : TelemetryEvent() {
    lateinit var character: Character
    lateinit var parentItem: Item
    lateinit var childItem: Item
}