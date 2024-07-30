package com.sb.park.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringSetPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class DataStoreRepositoryImpl @Inject constructor(private val dataStore: DataStore<Preferences>) :
    DataStoreRepository {

    override suspend fun saveVersion(version: Set<String>) {
        dataStore.edit {
            it[VERSION] = version
        }
    }

    override val getVersion: Flow<String> = dataStore.data.map {
        val data = it[VERSION] ?: setOf(DEFAULT_VERSION, System.currentTimeMillis().toString())
        data.toList()[0]
    }

    override val getDate: Flow<Long> = dataStore.data.map {
        val data = it[VERSION] ?: setOf(DEFAULT_VERSION, System.currentTimeMillis().toString())
        data.toList()[1].toLong()
    }

    override suspend fun saveIsDarkTheme(isDarkTheme: Boolean) {
        dataStore.edit {
            it[IS_DARK_THEME] = isDarkTheme
        }
    }

    override val getIsDarkTheme: Flow<Boolean> = dataStore.data.map {
        it[IS_DARK_THEME] ?: false
    }

    companion object {
        private const val DEFAULT_VERSION = "14.13.1"
        private val VERSION = stringSetPreferencesKey("LOL_VERSION")
        private val IS_DARK_THEME = booleanPreferencesKey("IS_DARK_THEME")
    }
}