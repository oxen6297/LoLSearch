package com.sb.park.domain.usecase

import com.sb.park.data.repository.ItemRepository
import com.sb.park.designsystem.UiState
import com.sb.park.model.ItemModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ItemInfoUseCase @Inject constructor(private val itemRepository: ItemRepository) {

    operator fun invoke(name: String): Flow<UiState<ItemModel>> = itemRepository.fetchItemInfo(name)
}