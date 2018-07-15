package de.kevcodez.pubg.model.telemetry.objects

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.JsonNode
import de.kevcodez.pubg.model.telemetry.enums.VehicleId

// TODO check
data class Vehicle(
    @JsonIgnore
    var vehicleType: String?,
    @JsonIgnore
    var vehicleId: VehicleId?,
    val healthPercent: Float,
    val feulPercent: Float
) {

    @JsonProperty("vehicleType")
    private fun unpackCategory(vehicleId: JsonNode) {
        val vehicleIdAsString = vehicleId.textValue()

        this.vehicleId = if (vehicleIdAsString.isNullOrBlank()) null else VehicleId.valueOf(vehicleIdAsString)
    }

}
