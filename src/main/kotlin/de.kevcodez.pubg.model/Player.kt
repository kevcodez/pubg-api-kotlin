package de.kevcodez.pubg.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Player(
    val id: String,
    val Name: String,
    val Stats: Any,
    val titleId: String,
    val shardId: String,
    val createdAt: String,
    val assets: List<Asset>,
    val patchVersion: String
)