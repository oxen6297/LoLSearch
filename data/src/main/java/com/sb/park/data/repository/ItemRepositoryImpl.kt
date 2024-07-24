package com.sb.park.data.repository

import com.sb.park.data.AppDispatchers
import com.sb.park.data.Dispatcher
import com.sb.park.data.mapper.toModel
import com.sb.park.data.room.ItemDao
import com.sb.park.data.service.DataDragonService
import com.sb.park.designsystem.UiState
import com.sb.park.designsystem.safeFlow
import com.sb.park.model.ItemModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


internal class ItemRepositoryImpl @Inject constructor(
    private val dataDragonService: DataDragonService,
    private val dataStoreRepository: DataStoreRepository,
    private val itemDao: ItemDao,
    @Dispatcher(AppDispatchers.IO) private val coroutineDispatcher: CoroutineDispatcher
) : ItemRepository {

    override fun fetchItem(): Flow<UiState<List<ItemModel>>> = safeFlow {

        val dbItemList = itemDao.getItemList()
        if (dbItemList.isNotEmpty()) {
            return@safeFlow dbItemList
        }

        val version = dataStoreRepository.getVersion.first()
        dataDragonService.getItem(version).data.values.asSequence().distinctBy { itemResponse ->
            itemResponse.name
        }.filter {
            it.gold.purchasable
        }.map { itemResponse ->
            itemResponse.toModel()
        }.sortedBy { itemModel ->
            itemModel.name
        }.toList().also { itemList ->
            itemDao.insertItem(itemList)
        }
    }.flowOn(coroutineDispatcher)

    override fun fetchItemInfo(name: String): Flow<UiState<ItemModel>> = safeFlow {
        itemDao.getItem(name)
    }.flowOn(coroutineDispatcher)
}