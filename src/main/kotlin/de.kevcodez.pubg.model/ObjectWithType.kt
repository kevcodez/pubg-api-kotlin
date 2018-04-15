package de.kevcodez.pubg.model

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes(
    JsonSubTypes.Type(value = ParticipantType::class, name = "participant"),
    JsonSubTypes.Type(value = RosterType::class, name = "roster"),
    JsonSubTypes.Type(value = Asset::class, name = "asset"),
    JsonSubTypes.Type(value = PlayerType::class, name = "player")
)
open class ObjectWithType