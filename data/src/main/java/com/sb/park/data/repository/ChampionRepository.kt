package com.sb.park.data.repository

import com.sb.park.designsystem.ApiResult
import com.sb.park.model.ChampionModel
import kotlinx.coroutines.flow.Flow

interface ChampionRepository {

    fun fetchChampion(): Flow<ApiResult<List<ChampionModel>>>
}