package com.sb.park.data.mapper

import com.sb.park.data.model.datadragon.ChampionInfoResponse
import com.sb.park.model.ChampionInfoModel

private object ChampionInfoMapper : ModelMapper<ChampionInfoResponse, ChampionInfoModel> {

    override fun asModel(response: ChampionInfoResponse): ChampionInfoModel = ChampionInfoModel(
        id = response.id,
        version = response.version,
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

    @JvmName("SkinToModel")
    private fun List<ChampionInfoResponse.SkinResponse>.toModel(): List<ChampionInfoModel.SkinModel> =
        map { skin ->
            ChampionInfoModel.SkinModel(
                num = skin.num,
                name = skin.name
            )
        }

    @JvmName("SpellToModel")
    private fun List<ChampionInfoResponse.SpellResponse>.toModel(): List<ChampionInfoModel.SpellModel> =
        map { spell ->
            ChampionInfoModel.SpellModel(
                id = spell.id,
                name = spell.name,
                description = spell.description,
                image = spell.image.toModel()
            )
        }

    private fun ChampionInfoResponse.PassiveResponse.toModel(): ChampionInfoModel.PassiveModel =
        ChampionInfoModel.PassiveModel(
            name = this.name,
            description = this.description,
            image = this.image.toModel()
        )
}

internal fun ChampionInfoResponse.toModel(): ChampionInfoModel = ChampionInfoMapper.asModel(this)