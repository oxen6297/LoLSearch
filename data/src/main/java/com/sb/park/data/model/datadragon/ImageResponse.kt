package com.sb.park.data.model.datadragon

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ImageResponse(
    @field:Json(name = "full") val full: String
)
