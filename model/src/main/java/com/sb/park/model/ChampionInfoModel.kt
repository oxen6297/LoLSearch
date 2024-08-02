package com.sb.park.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ChampionInfoModel(
    @PrimaryKey val id: String,
    val name: String,
    val title: String,
    val lore: String,
    val type: String,
    val image: ImageModel,
    val tags: List<String>,
    val tips: List<String>,
    val stats: StatModel,
    val skins: List<SkinModel>,
    val spells: List<SpellModel>,
    val passive: PassiveModel,
) {

    data class StatModel(
        val hp: Int,
        val mp: Int,
        val armor: Int,
        val attackRange: Int,
        val attackDamage: Int,
    ) {
        fun toList(): List<Int> = listOf(hp, mp, armor, attackDamage, attackRange)
    }

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