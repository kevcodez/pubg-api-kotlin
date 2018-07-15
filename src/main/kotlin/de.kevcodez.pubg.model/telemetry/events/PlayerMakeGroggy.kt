package de.kevcodez.pubg.model.telemetry.events

import com.fasterxml.jackson.annotation.JsonProperty
import de.kevcodez.pubg.model.telemetry.objects.Character

class PlayerMakeGroggy : TelemetryEvent() {
    var attackId: Int = 0
    lateinit var attacker: Character
    lateinit var victim: Character
    lateinit var damageTypeCategory: String
    lateinit var damageReason: String
    lateinit var damageCauserName: String
    var distance: Float = 0.0F
    @JsonProperty("isAttackerInVehicle")
    var isAttackerInVehicle: Boolean = false
    @JsonProperty("dBNOId")
    var dBNOId: Int = 0
}
