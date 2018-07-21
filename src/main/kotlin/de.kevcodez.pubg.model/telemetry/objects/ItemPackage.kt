package de.kevcodez.pubg.model.telemetry.objects

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class ItemPackage(
    val itemPackageId: String,
    val location: Location,
    val items: List<Item>
)
