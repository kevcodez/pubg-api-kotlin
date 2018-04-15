package de.kevcodez.pubg.model.match

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import de.kevcodez.pubg.model.player.PlayerType

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes(
    JsonSubTypes.Type(value = Participant::class, name = "participant"),
    JsonSubTypes.Type(value = Roster::class, name = "roster"),
    JsonSubTypes.Type(value = Asset::class, name = "asset"),
    JsonSubTypes.Type(value = PlayerType::class, name = "player")
)
open class MatchObject