package com.sb.park.data.model.datadragon

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RuneResponse(
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "key") val key: String,
    @field:Json(name = "icon") val icon: String,
    @field:Json(name = "name") val name: String,
    @field:Json(name = "slots") val slots: List<RuneSlot>
) {
    data class RuneSlot(
        @field:Json(name = "runes") val runes: List<Rune>
    )

    data class Rune(
        @field:Json(name = "id") val id: Int,
        @field:Json(name = "key") val key: String,
        @field:Json(name = "icon") val icon: String,
        @field:Json(name = "name") val name: String,
        @field:Json(name = "shortDesc") val shortDesc: String,
        @field:Json(name = "longDesc") val longDesc: String
    )
}