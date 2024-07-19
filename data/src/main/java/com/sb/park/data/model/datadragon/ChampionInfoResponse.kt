package com.sb.park.data.model.datadragon

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ChampionInfoResponse(
    @field:Json(name = "id") val id: String,
    @field:Json(name = "version") val version: String?,
    @field:Json(name = "name") val name: String,
    @field:Json(name = "title") val title: String,
    @field:Json(name = "lore") val lore: String,
    @field:Json(name = "partype") val partype: String,
    @field:Json(name = "image") val image: ImageResponse,
    @field:Json(name = "tags") val tags: List<String>,
    @field:Json(name = "allytips") val allytips: List<String>,
    @field:Json(name = "stats") val stats: StatResponse,
    @field:Json(name = "skins") val skins: List<SkinResponse>,
    @field:Json(name = "spells") val spells: List<SpellResponse>,
    @field:Json(name = "passive") val passive: PassiveResponse,
) {

    @JsonClass(generateAdapter = true)
    data class StatResponse(
        @field:Json(name = "hp") val hp: Int,
        @field:Json(name = "mp") val mp: Int,
        @field:Json(name = "armor") val armor: Int,
        @field:Json(name = "attackrange") val attackrange: Int,
        @field:Json(name = "attackdamage") val attackdamage: Int
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