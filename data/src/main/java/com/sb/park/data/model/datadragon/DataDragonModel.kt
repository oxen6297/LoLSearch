package com.sb.park.data.model.datadragon

import androidx.room.Entity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity
@JsonClass(generateAdapter = true)
data class DataDragonModel<T>(
    @field:Json(name = "data") val data: Map<String, T>
)
