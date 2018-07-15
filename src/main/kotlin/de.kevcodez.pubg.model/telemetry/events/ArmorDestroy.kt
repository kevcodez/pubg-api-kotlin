package de.kevcodez.pubg.model.telemetry.events

import de.kevcodez.pubg.model.telemetry.objects.Character
import de.kevcodez.pubg.model.telemetry.objects.Item

class ArmorDestroy : TelemetryEvent() {
    var attackId: Int = 0
    lateinit var attacker: Character
    lateinit var victim: Character
    lateinit var damageTypeCategory: String
    lateinit var damageReason: String
    lateinit var damageCauserName: String
    lateinit var item: Item
    var distance: Float = 0.0F
}
