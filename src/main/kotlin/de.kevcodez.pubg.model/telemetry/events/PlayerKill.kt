package de.kevcodez.pubg.model.telemetry.events

import de.kevcodez.pubg.model.telemetry.objects.Character

class PlayerKill : TelemetryEvent() {
    var attackId: Int = 0
    lateinit var killer: Character
    lateinit var victim: Character
    lateinit var damageTypeCategory: String
    lateinit var damageCauserName: String
    lateinit var damageReason: String
    var distance: Float = 0.0F
}