package de.kevcodez.pubg.model.telemetry.events

class PlayerLogin : TelemetryEvent() {
    var result: Boolean = false
    lateinit var errorMessage: String
    lateinit var accountId: String
}