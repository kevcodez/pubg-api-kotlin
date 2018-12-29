package de.kevcodez.pubg.model.telemetry.objects

data class Stats(
    val killCount: Int,
    val distanceOnFoot: Float,
    val distanceOnSwim: Float,
    val distanceOnVehicle: Float,
    val distanceOnParachute: Float,
    val distanceOnFreefall: Float
)