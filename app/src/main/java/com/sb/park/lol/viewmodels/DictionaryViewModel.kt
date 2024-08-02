package com.sb.park.lol.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sb.park.designsystem.UiState
import com.sb.park.domain.usecase.ChampionUseCase
import com.sb.park.domain.usecase.ItemUseCase
import com.sb.park.domain.usecase.VersionUseCase
import com.sb.park.model.ChampionModel
import com.sb.park.model.ItemModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
internal class DictionaryViewModel @Inject constructor(
    championUseCase: ChampionUseCase,
    itemUseCase: ItemUseCase,
    versionUseCase: VersionUseCase,
) : ViewModel() {

    val championUiStateFlow: StateFlow<UiState<List<ChampionModel>>> = championUseCase().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000L),
        initialValue = UiState.Loading
    )

    val itemUiStateFlow: StateFlow<UiState<List<ItemModel>>> = itemUseCase().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000L),
        initialValue = UiState.Loading
    )

    val versionFlow: StateFlow<String> = versionUseCase().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000L),
        initialValue = "14.13.1"
    )
}