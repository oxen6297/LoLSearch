package com.sb.park.domain.usecase

import com.sb.park.data.repository.DataStoreRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class VersionUseCase @Inject constructor(private val dataStoreRepository: DataStoreRepository) {

    operator fun invoke(): Flow<String> = dataStoreRepository.getVersion
}