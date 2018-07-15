package de.kevcodez.pubg.model.telemetry.objects

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.JsonNode
import de.kevcodez.pubg.model.telemetry.enums.Category
import de.kevcodez.pubg.model.telemetry.enums.SubCategory

data class Item(
    val itemId: String,
    val stackCount: Int,
    var itemCategory: Category? = null,
    var itemSubCategory: SubCategory?,
    val attachedItems: List<String>
) {
    @JsonProperty("category")
    private fun unpackCategory(category: JsonNode) {
        val categoryAsString = category.textValue()

        itemCategory = if (categoryAsString.isNullOrBlank()) null else Category.valueOf(categoryAsString)
    }

    @JsonProperty("subCategory")
    private fun unpackSubCategory(category: JsonNode) {
        val categoryAsString = category.textValue()

        itemSubCategory = if (categoryAsString.isNullOrBlank()) null else SubCategory.valueOf(categoryAsString)
    }
}
