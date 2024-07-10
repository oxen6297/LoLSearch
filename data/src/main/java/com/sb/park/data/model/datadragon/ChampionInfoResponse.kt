package com.sb.park.data.model.datadragon

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ChampionInfoResponse(
    @field:Json(name = "id") val id: String,
    @field:Json(name = "version") val version: String,
    @field:Json(name = "name") val name: String,
    @field:Json(name = "title") val title: String,
    @field:Json(name = "lore") val lore: String,
    @field:Json(name = "image") val image: ImageResponse,
    @field:Json(name = "tags") val tags: List<String>,
    @field:Json(name = "skins") val skins: List<SkinResponse>,
    @field:Json(name = "spells") val spells: List<SpellResponse>,
    @field:Json(name = "passive") val passive: PassiveResponse,
) {

    @JsonClass(generateAdapter = true)
    data class ImageResponse(
        @field:Json(name = "full") val fileName: String
    )

    @JsonClass(generateAdapter = true)
    data class SkinResponse(
        @field:Json(name = "num") val num: Int,
        @field:Json(name = "name") val name: String
    )

    @JsonClass(generateAdapter = true)
    data class SpellResponse(
        @field:Json(name = "id") val id: String,
        @field:Json(name = "name") val name: String,
        @field:Json(name = "description") val description: String,
        @field:Json(name = "image") val image: ImageResponse
    )

    @JsonClass(generateAdapter = true)
    data class PassiveResponse(
        @field:Json(name = "name") val name: String,
        @field:Json(name = "description") val description: String,
        @field:Json(name = "image") val image: ImageResponse
    )
}