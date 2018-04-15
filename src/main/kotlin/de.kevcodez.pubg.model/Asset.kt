package de.kevcodez.pubg.model

import java.time.Instant

class Asset : ObjectWithType() {
    lateinit var id: String
    lateinit var attributes: AssetAttributes
}

data class AssetAttributes(
    val URL: String,
    val createdAt: Instant,
    val description: String,
    val name: String
)
