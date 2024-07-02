package com.sb.park.domain.usecase

import com.sb.park.data.repository.VersionRepository
import com.sb.park.designsystem.UiState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class VersionUseCase @Inject constructor(private val versionRepository: VersionRepository) {

    operator fun invoke(): Flow<UiState<Unit>> = versionRepository.fetchVersion()
}