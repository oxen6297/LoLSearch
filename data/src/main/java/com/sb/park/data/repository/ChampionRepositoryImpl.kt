package com.sb.park.data.repository

import com.sb.park.data.AppDispatchers
import com.sb.park.data.Dispatcher
import com.sb.park.data.mapper.toModel
import com.sb.park.data.room.ChampionDao
import com.sb.park.data.room.ChampionInfoDao
import com.sb.park.data.service.DataDragonService
import com.sb.park.designsystem.UiState
import com.sb.park.designsystem.safeFlow
import com.sb.park.model.ChampionInfoModel
import com.sb.park.model.ChampionModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

internal class ChampionRepositoryImpl @Inject constructor(
    private val dataDragonService: DataDragonService,
    private val dataStoreRepository: DataStoreRepository,
    private val championDao: ChampionDao,
    private val championInfoDao: ChampionInfoDao,
    @Dispatcher(AppDispatchers.IO) private val coroutineDispatcher: CoroutineDispatcher
) : ChampionRepository {

    override fun fetchChampion(): Flow<UiState<List<ChampionModel>>> = safeFlow {
        fetchVersion()

        val dbChampionList = championDao.getChampionList()
        if (dbChampionList.isNotEmpty()) {
            return@safeFlow dbChampionList
        }

        val version = dataStoreRepository.getVersion.first()
        dataDragonService.getChampion(version).data.values.toList().map { championResponse ->
            championResponse.toModel()
        }.sortedBy {
            it.name
        }.also { championList ->
            championDao.insertChampion(championList)
        }
    }.flowOn(coroutineDispatcher)

    override fun fetchChampionInfo(championId: String): Flow<UiState<ChampionInfoModel>> = safeFlow {
        championInfoDao.getChampion(championId)?.let { dbChampionInfo ->
            return@safeFlow dbChampionInfo
        }

        val version = dataStoreRepository.getVersion.first()
        dataDragonService.getChampionInfo(version, championId).data.values.first().toModel()
            .also { champion ->
                championInfoDao.insertChampion(champion)
            }
    }.flowOn(coroutineDispatcher)

    override suspend fun fetchVersion() {
        val myVersion = dataStoreRepository.getVersion.first()
        val serverVersion = dataDragonService.getVersion().first()

        if (myVersion == serverVersion) {
            return
        }

        championDao.deleteChampionList()
        championInfoDao.deleteChampion()
        dataStoreRepository.saveVersion(serverVersion)
    }
}