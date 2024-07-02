package com.sb.park.data.repository

import com.sb.park.designsystem.UiState
import kotlinx.coroutines.flow.Flow

interface VersionRepository {

    fun fetchVersion(): Flow<UiState<Unit>>
}