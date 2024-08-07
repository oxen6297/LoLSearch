package com.sb.park.domain.usecase

import com.sb.park.data.repository.RuneRepository
import com.sb.park.designsystem.UiState
import com.sb.park.model.RuneModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RuneUseCase @Inject constructor(private val runeRepository: RuneRepository) {

    operator fun invoke(): Flow<UiState<RuneModel>> = runeRepository.fetchRune()
}