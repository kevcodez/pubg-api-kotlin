package de.kevcodez.pubg.model.status

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.node.ObjectNode
import java.time.Instant

@JsonIgnoreProperties(ignoreUnknown = true)
class Status {

    lateinit var releasedAt: Instant
    lateinit var version: String

    @JsonProperty("data")
    private fun unpackData(data: JsonNode) {
        val attributes = data.get("attributes") as ObjectNode
        releasedAt = Instant.parse(attributes.get("releasedAt").textValue())
        version = attributes.get("version").textValue()
    }
}