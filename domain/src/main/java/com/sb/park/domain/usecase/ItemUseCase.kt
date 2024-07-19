package com.sb.park.domain.usecase

import com.sb.park.data.repository.ItemRepository
import com.sb.park.designsystem.UiState
import com.sb.park.model.ItemModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ItemUseCase @Inject constructor(private val itemRepository: ItemRepository) {

    operator fun invoke(): Flow<UiState<List<ItemModel>>> = itemRepository.fetchItem()
}