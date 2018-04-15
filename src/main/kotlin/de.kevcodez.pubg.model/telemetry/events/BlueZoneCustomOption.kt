package de.kevcodez.pubg.model.telemetry.events

data class BlueZoneCustomOption(
    val phaseNum: Int,
    val startDelay: Int,
    val warningDuration: Int,
    val releaseDuration: Int,
    val poisonGasDamagePerSecond: Int,
    val radiusRate: Int
)