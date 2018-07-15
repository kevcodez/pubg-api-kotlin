package de.kevcodez.pubg.model.telemetry.events

import de.kevcodez.pubg.model.telemetry.enums.AttackType
import de.kevcodez.pubg.model.telemetry.objects.Character
import de.kevcodez.pubg.model.telemetry.objects.Item
import de.kevcodez.pubg.model.telemetry.objects.Vehicle

class PlayerAttack : TelemetryEvent() {
    var attackId: Int = 0
    lateinit var attacker: Character
    lateinit var attackType: AttackType
    lateinit var weapon: Item
    var vehicle: Vehicle? = null
}
