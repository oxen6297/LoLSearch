package com.sb.park.data.mapper

import com.sb.park.data.model.datadragon.ChampionInfoResponse
import com.sb.park.data.model.datadragon.ImageResponse
import com.sb.park.model.ChampionInfoModel
import com.sb.park.model.ImageModel

private object ChampionInfoMapper : ModelMapper<ChampionInfoResponse, ChampionInfoModel> {

    override fun asModel(response: ChampionInfoResponse): ChampionInfoModel = ChampionInfoModel(
        id = response.id,
        version = response.version ?: "14.13.1",
        name = response.name,
        title = response.title,
        lore = response.lore.deleteHtmlTag(),
        type = response.partype,
        image = response.image.toModel(),
        tags = response.tags,
        tips = response.allytips,
        stats = response.stats.toModel(),
        skins = response.skins.toModel(),
        spells = response.spells.toModel(),
        passive = response.passive.toModel()
    )

    private fun ImageResponse.toModel(): ImageModel = ImageModel(fileName = this.full)

    private fun ChampionInfoResponse.StatResponse.toModel(): ChampionInfoModel.StatModel =
        ChampionInfoModel.StatModel(
            hp = this.hp,
            mp = this.mp,
            armor = this.armor,
            attackRange = this.attackrange,
            attackDamage = this.attackdamage
        )

    @JvmName("SkinToModel")
    private fun List<ChampionInfoResponse.SkinResponse>.toModel(): List<ChampionInfoModel.SkinModel> =
        map { skin ->
            ChampionInfoModel.SkinModel(
                num = skin.num,
                name = skin.name.takeUnless { skinName -> skinName == "default" } ?: "기본"
            )
        }

    @JvmName("SpellToModel")
    private fun List<ChampionInfoResponse.SpellResponse>.toModel(): List<ChampionInfoModel.SpellModel> =
        map { spell ->
            ChampionInfoModel.SpellModel(
                id = spell.id,
                name = spell.name,
                description = spell.description.deleteHtmlTag(),
                image = spell.image.toModel()
            )
        }

    private fun ChampionInfoResponse.PassiveResponse.toModel(): ChampionInfoModel.PassiveModel =
        ChampionInfoModel.PassiveModel(
            name = this.name,
            description = this.description.deleteHtmlTag(),
            image = this.image.toModel()
        )
}

private fun String.deleteHtmlTag(): String = this.replace("<.*?>".toRegex(), "")

internal fun ChampionInfoResponse.toModel(): ChampionInfoModel = ChampionInfoMapper.asModel(this)