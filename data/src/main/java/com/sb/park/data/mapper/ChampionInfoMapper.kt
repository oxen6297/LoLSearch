package com.sb.park.data.mapper

import com.sb.park.data.model.datadragon.ChampionInfoResponse
import com.sb.park.model.ChampionInfoModel

fun ChampionInfoResponse.toModel(): ChampionInfoModel = ChampionInfoModel(
    id = this.id,
    name = this.name,
    title = this.title,
    lore = this.lore,
    image = this.image.toModel(),
    tags = this.tags,
    skins = this.skins.map { it.toModel() },
    spells = this.spells.map { it.toModel() },
    passive = this.passive.toModel()
)

fun ChampionInfoResponse.ImageResponse.toModel(): ChampionInfoModel.ImageModel =
    ChampionInfoModel.ImageModel(
        fileName = this.fileName
    )

fun ChampionInfoResponse.SkinResponse.toModel(): ChampionInfoModel.SkinModel =
    ChampionInfoModel.SkinModel(
        num = this.num,
        name = this.name
    )

fun ChampionInfoResponse.SpellResponse.toModel(): ChampionInfoModel.SpellModel =
    ChampionInfoModel.SpellModel(
        id = this.id,
        name = this.name,
        description = this.description,
        image = this.image.toModel()
    )

fun ChampionInfoResponse.PassiveResponse.toModel(): ChampionInfoModel.PassiveModel =
    ChampionInfoModel.PassiveModel(
        name = this.name,
        description = this.description,
        image = this.image.toModel()
    )