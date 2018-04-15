package de.kevcodez.pubg.model

class PlayerType : ObjectWithType() {
    lateinit var id: String
    lateinit var attributes: PlayerAttributes
    lateinit var relationships: Relationships
    lateinit var links: Link
}
