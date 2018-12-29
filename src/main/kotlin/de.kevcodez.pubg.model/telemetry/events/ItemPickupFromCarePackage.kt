package de.kevcodez.pubg.model.telemetry.events

import de.kevcodez.pubg.model.telemetry.objects.Character
import de.kevcodez.pubg.model.telemetry.objects.Item

class ItemPickupFromCarePackage : TelemetryEvent() {
    lateinit var character: Character
    lateinit var item: Item
}