package com.sb.park.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass

@Entity
@JsonClass(generateAdapter = true)
data class ChampionModel(
    @PrimaryKey val id: String,
    val name: String
)
