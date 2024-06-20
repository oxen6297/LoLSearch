package com.sb.park.data.repository

import com.sb.park.data.model.datadragon.ChampionModel
import com.sb.park.designsystem.ApiResult
import kotlinx.coroutines.flow.Flow

interface ChampionRepository {

    fun fetchChampion(): Flow<ApiResult<List<ChampionModel>>>
}