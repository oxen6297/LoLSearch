package com.sb.park.data.repository

import kotlinx.coroutines.flow.Flow

interface DataStoreRepository {

    suspend fun saveVersion(version: String)

    val getVersion: Flow<String>

    suspend fun saveIsDarkTheme(isDarkTheme: Boolean)

    val getIsDarkTheme: Flow<Boolean>
}