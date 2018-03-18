package de.kevcodez.pubg.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Asset(
    val id: String,
    val titleId: String,
    val shardId: String,
    val name: String,
    val description: String,
    val createdAt: String,
    val filename: String,
    val contentType: String,
    val URL: String
)
