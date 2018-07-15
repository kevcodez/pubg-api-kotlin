package de.kevcodez.pubg.model.telemetry.events

import de.kevcodez.pubg.model.telemetry.objects.GameState

class GameStatePeriodic : TelemetryEvent() {
    lateinit var gameState: GameState
}
