package com.sb.park.domain.usecase

import com.sb.park.data.repository.ChampionRepository
import com.sb.park.designsystem.UiState
import com.sb.park.model.ChampionModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ChampionUseCase @Inject constructor(private val championRepository: ChampionRepository) {

    operator fun invoke(): Flow<UiState<List<ChampionModel>>> = championRepository.fetchChampion()
}