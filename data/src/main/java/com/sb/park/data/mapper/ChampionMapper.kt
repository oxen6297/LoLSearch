package com.sb.park.data.mapper

import com.sb.park.data.model.datadragon.ChampionResponse
import com.sb.park.model.ChampionModel

fun ChampionResponse.toData(): ChampionModel = ChampionModel(
    id = this.id,
    name = this.name
)