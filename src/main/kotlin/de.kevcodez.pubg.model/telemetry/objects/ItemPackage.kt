package de.kevcodez.pubg.model.telemetry.objects

data class ItemPackage(
    val itemPackageId: String,
    val location: Location,
    val items: List<Item>
)
