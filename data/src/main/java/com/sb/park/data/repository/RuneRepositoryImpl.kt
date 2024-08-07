package com.sb.park.data.repository

import com.sb.park.data.AppDispatchers
import com.sb.park.data.Dispatcher
import com.sb.park.data.mapper.toModel
import com.sb.park.data.room.RuneDao
import com.sb.park.data.service.DataDragonService
import com.sb.park.designsystem.UiState
import com.sb.park.designsystem.safeFlow
import com.sb.park.model.RuneModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

internal class RuneRepositoryImpl @Inject constructor(
    private val dataDragonService: DataDragonService,
    private val dataStoreRepository: DataStoreRepository,
    private val runeDao: RuneDao,
    @Dispatcher(AppDispatchers.IO) private val coroutineDispatcher: CoroutineDispatcher
) : RuneRepository {

    override fun fetchRune(): Flow<UiState<RuneModel>> = safeFlow {

        runeDao.getRuneList()?.let { dbRuneModel ->
            return@safeFlow dbRuneModel
        }

        val version = dataStoreRepository.getVersion.first()
        dataDragonService.getRune(version).toModel().also { rune ->
            runeDao.insertRune(rune)
        }
    }.flowOn(coroutineDispatcher)
}