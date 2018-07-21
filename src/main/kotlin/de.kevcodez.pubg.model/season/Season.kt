package de.kevcodez.pubg.model.season

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.JsonNode

@JsonIgnoreProperties(ignoreUnknown = true)
data class Season(
    val id: String,
    val type: String,
    var isCurrentSeason: Boolean,
    var isOffseason: Boolean
) {
    @JsonProperty("attributes")
    private fun unpackAttributes(matches: JsonNode) {
        isCurrentSeason = matches.get("isCurrentSeason").booleanValue()
        isOffseason = matches.get("isOffseason").booleanValue()
    }
}
