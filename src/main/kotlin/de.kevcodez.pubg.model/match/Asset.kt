package de.kevcodez.pubg.model.match

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.time.Instant

class Asset : MatchObject() {
    lateinit var id: String
    lateinit var attributes: AssetAttributes
}

@JsonIgnoreProperties(ignoreUnknown = true)
data class AssetAttributes(
    val URL: String,
    val createdAt: Instant,
    val description: String,
    val name: String
)
