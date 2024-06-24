package com.sb.park.data.repository

import com.sb.park.designsystem.ApiResult
import kotlinx.coroutines.flow.Flow

interface VersionRepository {

    fun setVersion(): Flow<ApiResult<Unit>>
}