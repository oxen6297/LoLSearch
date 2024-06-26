package com.sb.park.data.model.datadragon

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ChampionResponse(
    @field:Json(name = "id") val id: String,
    @field:Json(name = "name") val name: String
)
