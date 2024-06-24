package com.sb.park.data.repository

import kotlinx.coroutines.flow.Flow

interface DataStoreRepository {

    suspend fun saveVersion(version: String)

    val getVersion: Flow<String>
}