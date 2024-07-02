package com.sb.park.domain.usecase

import com.sb.park.data.repository.ChampionRepository
import com.sb.park.designsystem.UiState
import com.sb.park.model.ChampionInfoModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ChampionInfoUseCase @Inject constructor(private val championRepository: ChampionRepository) {

    operator fun invoke(name: String): Flow<UiState<ChampionInfoModel>> =
        championRepository.fetchChampionInfo(name)
}