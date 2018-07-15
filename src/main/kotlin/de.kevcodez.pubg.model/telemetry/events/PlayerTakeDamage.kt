package de.kevcodez.pubg.model.telemetry.events

import de.kevcodez.pubg.model.telemetry.enums.DamageReason
import de.kevcodez.pubg.model.telemetry.objects.Character

class PlayerTakeDamage : TelemetryEvent() {
    var attackId: Int = 0
    var attacker: Character? = null
    lateinit var victim: Character
    lateinit var damageTypeCategory: String
    lateinit var damageReason: DamageReason
    var damage: Float = 0.0F
    lateinit var damageCauserName: String
}
