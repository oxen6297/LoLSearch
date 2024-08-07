package com.sb.park.data.repository

import com.sb.park.designsystem.UiState
import com.sb.park.model.RuneModel
import kotlinx.coroutines.flow.Flow

interface RuneRepository {

    fun fetchRune(): Flow<UiState<RuneModel>>
}