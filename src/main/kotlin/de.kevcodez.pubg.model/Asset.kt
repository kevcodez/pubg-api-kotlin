package de.kevcodez.pubg.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

/**
 * Asset objects contain a URL string that links to a telemetry.json file, which will contain an array of event objects that provide further insight into a match.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
data class Asset(
    /** Asset ID */
    val id: String,
    /** Identifies the studio and game */
    val titleId: String,
    /** Platform-region shard */
    val shardId: String,
    /** Telemetry */
    val name: String,
    val description: String,
    /** Time of telemetry creation */
    val createdAt: String,
    /** telemetry.json */
    val filename: String,
    val contentType: String,
    /** Link to the telemetry.json file */
    val URL: String
)
