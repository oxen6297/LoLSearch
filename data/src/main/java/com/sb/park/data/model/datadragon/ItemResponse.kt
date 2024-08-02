package com.sb.park.data.model.datadragon

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ItemResponse(
    @field:Json(name = "name") val name: String,
    @field:Json(name = "plaintext") val plaintext: String,
    @field:Json(name = "into") val into: List<String>?,
    @field:Json(name = "from") val from: List<String>?,
    @field:Json(name = "image") val image: ImageResponse,
    @field:Json(name = "image") val gold: GoldResponse,
    @field:Json(name = "tags") val tags: List<String>,
) {

    @JsonClass(generateAdapter = true)
    data class GoldResponse(
        @field:Json(name = "purchasable") val purchasable: Boolean,
        @field:Json(name = "total") val total: Int,
        @field:Json(name = "sell") val sell: Int
    )
}
