package de.kevcodez.pubg.model.tournament

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties("links", "meta")
data class TournamentsResponse(
    @JsonProperty("data")
    val tournaments: List<Tournament>
)
