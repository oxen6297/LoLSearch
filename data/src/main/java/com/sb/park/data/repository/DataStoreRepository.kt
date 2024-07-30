package com.sb.park.data.repository

import kotlinx.coroutines.flow.Flow

interface DataStoreRepository {

    suspend fun saveVersion(version: Set<String>)

    val getVersion: Flow<String>

    val getDate: Flow<Long>

    suspend fun saveIsDarkTheme(isDarkTheme: Boolean)

    val getIsDarkTheme: Flow<Boolean>
}