package de.kevcodez.pubg.model.telemetry.events

import de.kevcodez.pubg.model.telemetry.objects.Character

class WeaponFireCount : TelemetryEvent() {
    lateinit var character: Character
    lateinit var weaponId: String
    var fireCount: Int = 0
}