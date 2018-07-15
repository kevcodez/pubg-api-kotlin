package de.kevcodez.pubg.model.tournament

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.node.ArrayNode
import java.time.Instant

@JsonIgnoreProperties("links", "meta")
data class TournamentResponse(
    @JsonProperty("data")
    val tournament: Tournament
) {

    lateinit var matches: List<TournamentMatch>

    @JsonProperty("included")
    private fun unpackMatches(included: JsonNode) {
        val includedArray = included as ArrayNode

        val parsedMatches = mutableListOf<TournamentMatch>()
        includedArray.forEach {
            parsedMatches.add(
                TournamentMatch(
                    matchId = it.get("id").textValue(),
                    createdAt = Instant.parse(it.get("attributes").get("createdAt").textValue())
                )
            )
        }

        matches = parsedMatches
    }
}

data class TournamentMatch(
    val matchId: String,
    val createdAt: Instant
)