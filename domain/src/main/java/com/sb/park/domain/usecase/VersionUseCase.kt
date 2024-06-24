package com.sb.park.domain.usecase

import com.sb.park.data.repository.VersionRepository
import com.sb.park.designsystem.ApiResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class VersionUseCase @Inject constructor(private val versionRepository: VersionRepository) {

    operator fun invoke(): Flow<ApiResult<Unit>> = versionRepository.setVersion()
}