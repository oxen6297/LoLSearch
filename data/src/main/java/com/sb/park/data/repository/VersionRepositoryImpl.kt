package com.sb.park.data.repository

import com.sb.park.data.room.ChampionDao
import com.sb.park.data.room.ChampionInfoDao
import com.sb.park.data.service.DataDragonService
import com.sb.park.designsystem.UiState
import com.sb.park.designsystem.safeFlow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import javax.inject.Inject

internal class VersionRepositoryImpl @Inject constructor(
    private val dataDragonService: DataDragonService,
    private val dataStoreRepository: DataStoreRepository,
    private val championDao: ChampionDao,
    private val championInfoDao: ChampionInfoDao
) : VersionRepository {

    override fun fetchVersion(): Flow<UiState<Unit>> = safeFlow {
        val serverVersion = dataDragonService.getVersion().first()
        val myVersion = dataStoreRepository.getVersion.first()

        if (serverVersion == myVersion) return@safeFlow

        championDao.deleteChampionList()
        championInfoDao.deleteChampion()
        dataStoreRepository.saveVersion(serverVersion)
    }
}