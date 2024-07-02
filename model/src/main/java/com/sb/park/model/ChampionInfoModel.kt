package com.sb.park.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ChampionInfoModel(
    @PrimaryKey val id: String,
    val name: String,
    val title: String,
    val lore: String,
    val image: ImageModel,
    val tags: List<String>,
    val skins: List<SkinModel>,
    val spells: List<SpellModel>,
    val passive: PassiveModel,
) {
    data class ImageModel(
        val fileName: String
    )

    data class SkinModel(
        val num: Int,
        val name: String
    )

    data class SpellModel(
        val id: String,
        val name: String,
        val description: String,
        val image: ImageModel
    )

    data class PassiveModel(
        val name: String,
        val description: String,
        val image: ImageModel
    )
}