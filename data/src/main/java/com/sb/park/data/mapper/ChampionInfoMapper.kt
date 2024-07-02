package com.sb.park.data.mapper

import com.sb.park.data.model.datadragon.ChampionInfoResponse
import com.sb.park.model.ChampionInfoModel

private object ChampionInfoMapper : ModelMapper<ChampionInfoResponse, ChampionInfoModel> {
    
    override fun asModel(response: ChampionInfoResponse): ChampionInfoModel = ChampionInfoModel(
        id = response.id,
        name = response.name,
        title = response.title,
        lore = response.lore,
        image = response.image.toModel(),
        tags = response.tags,
        skins = response.skins.map { it.toModel() },
        spells = response.spells.map { it.toModel() },
        passive = response.passive.toModel()
    )

    private fun ChampionInfoResponse.ImageResponse.toModel(): ChampionInfoModel.ImageModel =
        ChampionInfoModel.ImageModel(
            fileName = this.fileName
        )

    private fun ChampionInfoResponse.SkinResponse.toModel(): ChampionInfoModel.SkinModel =
        ChampionInfoModel.SkinModel(
            num = this.num,
            name = this.name
        )

    private fun ChampionInfoResponse.SpellResponse.toModel(): ChampionInfoModel.SpellModel =
        ChampionInfoModel.SpellModel(
            id = this.id,
            name = this.name,
            description = this.description,
            image = this.image.toModel()
        )

    private fun ChampionInfoResponse.PassiveResponse.toModel(): ChampionInfoModel.PassiveModel =
        ChampionInfoModel.PassiveModel(
            name = this.name,
            description = this.description,
            image = this.image.toModel()
        )
}

internal fun ChampionInfoResponse.toModel(): ChampionInfoModel = ChampionInfoMapper.asModel(this)