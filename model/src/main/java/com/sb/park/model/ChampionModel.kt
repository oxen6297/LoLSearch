package com.sb.park.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ChampionModel(
    @PrimaryKey val id: String,
    val name: String
)
