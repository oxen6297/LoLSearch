package com.sb.park.data.repository

import com.sb.park.data.model.datadragon.ChampionModel
import com.sb.park.data.service.DataDragonService
import com.sb.park.designsystem.ApiResult
import com.sb.park.designsystem.safeFlow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import javax.inject.Inject

internal class ChampionRepositoryImpl @Inject constructor(
    private val dataDragonService: DataDragonService,
    private val dataStoreRepository: DataStoreRepository
) : ChampionRepository {

    override fun fetchChampion(): Flow<ApiResult<List<ChampionModel>>> = safeFlow {
        val version = dataStoreRepository.getVersion.first()
        dataDragonService.getChampion<ChampionModel>(version).data.values.toList()
    }
}