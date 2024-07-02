package com.sb.park.data.repository

import com.sb.park.data.mapper.toModel
import com.sb.park.data.room.ChampionDao
import com.sb.park.data.room.ChampionInfoDao
import com.sb.park.data.service.DataDragonService
import com.sb.park.designsystem.UiState
import com.sb.park.designsystem.safeFlow
import com.sb.park.model.ChampionInfoModel
import com.sb.park.model.ChampionModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import javax.inject.Inject

internal class ChampionRepositoryImpl @Inject constructor(
    private val dataDragonService: DataDragonService,
    private val dataStoreRepository: DataStoreRepository,
    private val championDao: ChampionDao,
    private val championInfoDao: ChampionInfoDao
) : ChampionRepository {

    override fun fetchChampion(): Flow<UiState<List<ChampionModel>>> = safeFlow {

        val dbChampionList = championDao.getChampionList()

        if (dbChampionList.isNotEmpty()) {
            return@safeFlow dbChampionList
        }

        val version = dataStoreRepository.getVersion.first()
        dataDragonService.getChampion(version).data.values.toList().map { champion ->
            champion.toModel()
        }.also { championList ->
            championDao.insertChampion(championList)
        }
    }

    override fun fetchChampionInfo(name: String): Flow<UiState<ChampionInfoModel>> = safeFlow {

        val dbChampionInfo = championInfoDao.getChampion()

        if (dbChampionInfo != null) {
            return@safeFlow dbChampionInfo
        }

        val version = dataStoreRepository.getVersion.first()
        dataDragonService.getChampionInfo(version, name).data.values.first().toModel()
            .also { champion ->
                championInfoDao.insertChampion(champion)
            }
    }
}