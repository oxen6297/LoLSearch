package com.sb.park.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class DataStoreRepositoryImpl @Inject constructor(private val dataStore: DataStore<Preferences>) :
    DataStoreRepository {

    override suspend fun saveVersion(version: String) {
        dataStore.edit {
            it[VERSION] = version
        }
    }

    override val getVersion: Flow<String> = dataStore.data.map {
        it[VERSION] ?: "14.12.1"
    }

    companion object {
        private val VERSION = stringPreferencesKey("LOL_VERSION")
    }
}