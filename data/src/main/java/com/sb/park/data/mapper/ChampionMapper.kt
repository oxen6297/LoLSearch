package com.sb.park.data.mapper

import com.sb.park.data.model.datadragon.ChampionResponse
import com.sb.park.model.ChampionModel
private object ChampionMapper : ModelMapper<ChampionResponse, ChampionModel> {

    override fun asModel(response: ChampionResponse): ChampionModel = ChampionModel(
        id = response.id,
        name = response.name
    )
}

internal fun ChampionResponse.toModel(): ChampionModel = ChampionMapper.asModel(this)