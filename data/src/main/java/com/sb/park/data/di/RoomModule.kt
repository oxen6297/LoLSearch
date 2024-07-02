package com.sb.park.data.di

import android.content.Context
import androidx.room.Room
import com.sb.park.data.room.ChampionDao
import com.sb.park.data.room.ChampionInfoDao
import com.sb.park.data.room.LOLDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideLoLDatabase(
        @ApplicationContext context: Context,
    ): LOLDataBase = Room
        .databaseBuilder(context, LOLDataBase::class.java, "LOL.db")
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun provideChampionDao(lolDataBase: LOLDataBase): ChampionDao = lolDataBase.championDao()

    @Provides
    @Singleton
    fun provideChampionInfoDao(lolDataBase: LOLDataBase): ChampionInfoDao = lolDataBase.championInfoDao()
}