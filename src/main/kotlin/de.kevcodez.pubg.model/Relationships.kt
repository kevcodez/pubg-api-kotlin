package de.kevcodez.pubg.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.node.ArrayNode

data class Relationships(
    val matches: Matches?,
    var participantIds: List<String>?,
    val team: Any?,
    val assets: Any?,
    var rosterIds: List<String>?,
    val rounds: Any?,
    val spectators: Any?
) {
    @JsonProperty("participants")
    private fun unpackParticipantIds(participants: JsonNode) {
        val data = participants.get("data") as ArrayNode

        participantIds = data.map { it.get("id").textValue() }.toList()
    }

    @JsonProperty("rosters")
    private fun unpackRosterIds(rosters: JsonNode) {
        val data = rosters.get("data") as ArrayNode

        rosterIds = data.map { it.get("id").textValue() }.toList()
    }
}

data class RelationParticipantData(
    val data: RelationParticipant
)

data class RelationParticipant(
    val id: String
)