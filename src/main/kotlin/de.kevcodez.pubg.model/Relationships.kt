package de.kevcodez.pubg.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.node.ArrayNode

@JsonIgnoreProperties(ignoreUnknown = true)
data class Relationships(
    var matchIds: List<String>?,
    var participantIds: List<String>?,
    var assetIds: List<String>?,
    var rosterIds: List<String>?
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

    @JsonProperty("matches")
    private fun unpackMatchIds(matches: JsonNode) {
        val data = matches.get("data") as ArrayNode

        matchIds = data.map { it.get("id").textValue() }.toList()
    }

    @JsonProperty("assets")
    private fun unpackAssetIds(assets: JsonNode) {
        val data = assets.get("data") as ArrayNode

        assetIds = data.map { it.get("id").textValue() }.toList()
    }
}
