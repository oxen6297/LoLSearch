package com.sb.park.lol.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sb.park.designsystem.UiState
import com.sb.park.domain.usecase.ItemInfoUseCase
import com.sb.park.lol.utils.KeyFile
import com.sb.park.model.ItemModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
internal class ItemInfoViewModel @Inject constructor(
    itemInfoUseCase: ItemInfoUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val name: String = checkNotNull(savedStateHandle[KeyFile.ITEM_NAME])

    val uiStateFlow: StateFlow<UiState<ItemModel>> = itemInfoUseCase(name).stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000L),
        initialValue = UiState.Loading
    )
}