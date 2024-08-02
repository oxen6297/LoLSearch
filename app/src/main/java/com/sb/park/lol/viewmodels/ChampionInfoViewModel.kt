package com.sb.park.lol.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sb.park.designsystem.UiState
import com.sb.park.domain.usecase.ChampionInfoUseCase
import com.sb.park.domain.usecase.VersionUseCase
import com.sb.park.lol.utils.KeyFile
import com.sb.park.model.ChampionInfoModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
internal class ChampionInfoViewModel @Inject constructor(
    championInfoUseCase: ChampionInfoUseCase,
    versionUseCase: VersionUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val championId: String = checkNotNull(savedStateHandle[KeyFile.CHAMPION_ID])

    val uiStateFlow: StateFlow<UiState<ChampionInfoModel>> = championInfoUseCase(championId).stateIn(
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