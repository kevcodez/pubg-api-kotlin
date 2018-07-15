package de.kevcodez.pubg.model.telemetry.events

import de.kevcodez.pubg.model.telemetry.objects.Character
import de.kevcodez.pubg.model.telemetry.objects.Vehicle

class VehicleDestroy : TelemetryEvent() {
    var attackId: Int = 0
    lateinit var attacker: Character
    lateinit var vehicle: Vehicle
    lateinit var damageTypeCategory: String
    lateinit var damageCauserName: String
    var distance: Float = 0.0F
}
