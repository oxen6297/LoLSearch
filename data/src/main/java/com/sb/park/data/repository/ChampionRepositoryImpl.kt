package com.sb.park.data.repository

import com.sb.park.data.mapper.toData
import com.sb.park.data.room.ChampionDao
import com.sb.park.data.service.DataDragonService
import com.sb.park.designsystem.ApiResult
import com.sb.park.designsystem.safeFlow
import com.sb.park.model.ChampionModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import javax.inject.Inject

internal class ChampionRepositoryImpl @Inject constructor(
    private val dataDragonService: DataDragonService,
    private val dataStoreRepository: DataStoreRepository,
    private val championDao: ChampionDao
) : ChampionRepository {

    override fun fetchChampion(): Flow<ApiResult<List<ChampionModel>>> = safeFlow {

        val championList = championDao.getChampionList()

        if (championList.isNotEmpty()) {
            return@safeFlow championList
        }

        val version = dataStoreRepository.getVersion.first()
        dataDragonService.getChampion(version).data.values.toList().map {
            it.toData()
        }.also {
            championDao.insertChampion(it)
        }
    }
}