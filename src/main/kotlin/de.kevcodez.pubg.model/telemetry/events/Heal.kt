package de.kevcodez.pubg.model.telemetry.events

import de.kevcodez.pubg.model.telemetry.objects.Character
import de.kevcodez.pubg.model.telemetry.objects.Item

class Heal : TelemetryEvent() {
    lateinit var character: Character
    lateinit var item: Item
    var healAmount: Float = 0.0F
}
