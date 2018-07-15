package de.kevcodez.pubg.model.telemetry.events

import de.kevcodez.pubg.model.telemetry.objects.ItemPackage

class CarePackageLand : TelemetryEvent() {
    lateinit var itemPackage: ItemPackage
}
