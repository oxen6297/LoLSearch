package com.sb.park.data.model.datadragon

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity
@JsonClass(generateAdapter = true)
data class ChampionModel(
    @field:Json(name = "id") @PrimaryKey val id: String,
    @field:Json(name = "name") val name: String
)
