package de.kevcodez.pubg.model.telemetry.events

import de.kevcodez.pubg.model.telemetry.objects.Character
import de.kevcodez.pubg.model.telemetry.objects.GameResult

class PlayerKill : TelemetryEvent() {
    var attackId: Int = 0
    lateinit var killer: Character
    lateinit var victim: Character
    var dBNOId: Int = 0
    lateinit var damageTypeCategory: String
    lateinit var damageCauserName: String
    var damageCauserAdditionalInfo: List<String>? = null
    lateinit var damageReason: String
    var distance: Float = 0.0F
    lateinit var victimGameResult: GameResult
}
