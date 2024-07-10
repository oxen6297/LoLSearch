package com.sb.park.data.repository

import com.sb.park.designsystem.UiState
import com.sb.park.model.ChampionInfoModel
import com.sb.park.model.ChampionModel
import kotlinx.coroutines.flow.Flow

interface ChampionRepository {

    fun fetchChampion(): Flow<UiState<List<ChampionModel>>>

    fun fetchChampionInfo(championId: String): Flow<UiState<ChampionInfoModel>>
}

