package de.kevcodez.pubg.model.telemetry.events

import de.kevcodez.pubg.model.telemetry.objects.Character
import de.kevcodez.pubg.model.telemetry.objects.Vehicle

class VehicleLeave : TelemetryEvent() {
    lateinit var character: Character
    lateinit var vehicle: Vehicle
    var rideDistance: Float = 0.0F
    var seatIndex: Int = 0
}