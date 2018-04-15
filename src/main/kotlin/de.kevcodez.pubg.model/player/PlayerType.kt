package de.kevcodez.pubg.model.player

import de.kevcodez.pubg.model.Link
import de.kevcodez.pubg.model.Relationships
import de.kevcodez.pubg.model.match.MatchObject

class PlayerType : MatchObject() {
    lateinit var id: String
    lateinit var attributes: PlayerAttributes
    lateinit var relationships: Relationships
    lateinit var links: Link
}
