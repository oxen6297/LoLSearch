package com.sb.park.data.repository

import com.sb.park.data.service.DataDragonService
import com.sb.park.designsystem.ApiResult
import com.sb.park.designsystem.safeFlow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class VersionRepositoryImpl @Inject constructor(
    private val dataDragonService: DataDragonService,
    private val dataStoreRepository: DataStoreRepository
) : VersionRepository {

    override fun setVersion(): Flow<ApiResult<Unit>> = safeFlow {
        val serverVersion = dataDragonService.getVersion().first()
        val myVersion = dataStoreRepository.getVersion.first()

        if (serverVersion == myVersion) return@safeFlow

        dataStoreRepository.saveVersion(serverVersion)
    }
}