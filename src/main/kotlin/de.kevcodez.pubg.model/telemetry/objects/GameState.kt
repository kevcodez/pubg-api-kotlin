package de.kevcodez.pubg.model.telemetry.objects

data class GameState(
    val elapsedTime: Int,
    val numAliveTeams: Int,
    val numJoinPlayers: Int,
    val numStartPlayers: Int,
    val numAlivePlayers: Int,
    val safetyZonePosition: Location,
    val safetyZoneRadius: Float,
    val poisonGasWarningPosition: Location,
    val poisonGasWarningRadius: Float,
    val redZonePosition: Location,
    val redZoneRadius: Float
)
