package de.kevcodez.pubg.model.telemetry.events

import de.kevcodez.pubg.model.telemetry.objects.Character
import de.kevcodez.pubg.model.telemetry.objects.Vehicle

class VehicleRide : TelemetryEvent() {
    lateinit var character: Character
    lateinit var vehicle: Vehicle
    var seatIndex: Int = 0
}
