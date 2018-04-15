package de.kevcodez.pubg.model

class Asset : ObjectWithType() {
    lateinit var id: String
    lateinit var attributes: AssetAttributes
}

data class AssetAttributes(
    val URL: String,
    val createdAt: String,
    val description: String,
    val name: String
)
