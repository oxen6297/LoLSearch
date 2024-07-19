package com.sb.park.data.di

import com.sb.park.data.repository.ChampionRepository
import com.sb.park.data.repository.ChampionRepositoryImpl
import com.sb.park.data.repository.DataStoreRepository
import com.sb.park.data.repository.DataStoreRepositoryImpl
import com.sb.park.data.repository.ItemRepository
import com.sb.park.data.repository.ItemRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RepositoryModule {

    @Binds
    abstract fun provideDataStoreRepository(dataStoreRepositoryImpl: DataStoreRepositoryImpl): DataStoreRepository

    @Binds
    abstract fun provideChampionRepository(championRepositoryImpl: ChampionRepositoryImpl): ChampionRepository

    @Binds
    abstract fun provideItemRepository(itemRepositoryImpl: ItemRepositoryImpl): ItemRepository
}