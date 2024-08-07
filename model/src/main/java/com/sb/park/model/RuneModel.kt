package com.sb.park.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RuneModel(
    @PrimaryKey val id: Int,
    val key: String,
    val icon: String,
    val name: String,
    val slots: List<RuneSlot>
) {
    data class RuneSlot(
        val runes: List<Rune>
    )

    data class Rune(
        val id: Int,
        val key: String,
        val icon: String,
        val name: String,
        val shortDesc: String,
        val longDesc: String
    )
}