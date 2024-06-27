package com.sb.park.lol.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sb.park.designsystem.ApiResult
import com.sb.park.domain.usecase.ChampionUseCase
import com.sb.park.model.ChampionModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class DictionaryViewModel @Inject constructor(championUseCase: ChampionUseCase) : ViewModel() {

    val championFlow: StateFlow<ApiResult<List<ChampionModel>>> = championUseCase().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000L),
        initialValue = ApiResult.Loading
    )
}