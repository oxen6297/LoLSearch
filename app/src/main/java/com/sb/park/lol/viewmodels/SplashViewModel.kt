package com.sb.park.lol.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sb.park.designsystem.ApiResult
import com.sb.park.domain.usecase.VersionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(versionUseCase: VersionUseCase) : ViewModel() {

    val versionFlow: StateFlow<ApiResult<Unit>> = versionUseCase().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000L),
        initialValue = ApiResult.Loading
    )
}