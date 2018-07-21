package de.kevcodez.pubg.model.telemetry.objects

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Character(
    val name: String,
    val teamId: Int,
    val health: Float,
    val location: Location,
    val ranking: Int,
    val accountId: String
)
