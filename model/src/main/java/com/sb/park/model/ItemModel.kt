package com.sb.park.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ItemModel(
    @PrimaryKey val name: String,
    val plaintext: String,
    val into: List<String>?,
    val from: List<String>?,
    val image: ImageModel,
    val gold: GoldModel,
    val tags: List<String>,
) {

    data class GoldModel(
        val purchasable: Boolean,
        val total: Int,
        val sell: Int
    )
}