package com.sb.park.domain.usecase

import com.sb.park.data.model.datadragon.ChampionModel
import com.sb.park.data.repository.ChampionRepository
import com.sb.park.designsystem.ApiResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ChampionUseCase @Inject constructor(private val championRepository: ChampionRepository) {

    operator fun invoke(): Flow<ApiResult<List<ChampionModel>>> = championRepository.fetchChampion()
}