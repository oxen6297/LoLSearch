package com.sb.park.data.mapper

import com.sb.park.data.model.datadragon.ChampionInfoResponse
import com.sb.park.model.ChampionInfoModel

object ChampionInfoMapper : ModelMapper<ChampionInfoResponse, ChampionInfoModel> {
    override fun asModel(response: ChampionInfoResponse): ChampionInfoModel = ChampionInfoModel(
        id = response.id,
        name = response.name,
        title = response.title,
        lore = response.lore,
        image = response.image.toModel(),
        tags = response.tags,
        skins = response.skins.toModel(),
        spells = response.spells.toModel(),
        passive = response.passive.toModel()
    )

    private fun ChampionInfoResponse.ImageResponse.toModel(): ChampionInfoModel.ImageModel =
        ChampionInfoModel.ImageModel(
            fileName = this.fileName
        )

    private fun List<ChampionInfoResponse.SkinResponse>.toModel(): List<ChampionInfoModel.SkinModel> =
        map { response ->
            ChampionInfoModel.SkinModel(
                num = response.num,
                name = response.name
            )
        }

    private fun List<ChampionInfoResponse.SpellResponse>.toModel(): List<ChampionInfoModel.SpellModel> =
        map { response ->
            ChampionInfoModel.SpellModel(
                id = response.id,
                name = response.name,
                description = response.description,
                image = response.image.toModel()
            )
        }

    private fun ChampionInfoResponse.PassiveResponse.toModel(): ChampionInfoModel.PassiveModel =
        ChampionInfoModel.PassiveModel(
            name = this.name,
            description = this.description,
            image = this.image.toModel()
        )
}

fun ChampionInfoResponse.toModel(): ChampionInfoModel = ChampionInfoMapper.asModel(this)