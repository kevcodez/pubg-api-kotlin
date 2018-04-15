package de.kevcodez.pubg.model

class PlayerType : MatchObject() {
    lateinit var id: String
    lateinit var attributes: PlayerAttributes
    lateinit var relationships: Relationships
    lateinit var links: Link
}
