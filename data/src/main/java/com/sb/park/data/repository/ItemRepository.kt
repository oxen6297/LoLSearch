package com.sb.park.data.repository

import com.sb.park.designsystem.UiState
import com.sb.park.model.ItemModel
import kotlinx.coroutines.flow.Flow

interface ItemRepository {

    fun fetchItem(): Flow<UiState<List<ItemModel>>>

    fun fetchItemInfo(name: String): Flow<UiState<ItemModel>>
}