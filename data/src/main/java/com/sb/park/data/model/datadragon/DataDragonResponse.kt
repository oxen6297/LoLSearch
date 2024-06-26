package com.sb.park.data.model.datadragon

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DataDragonResponse<T>(
    @field:Json(name = "data") val data: Map<String, T>
)
