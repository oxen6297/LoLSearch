package com.sb.park.data.di

import android.content.Context
import androidx.room.Room
import com.sb.park.data.room.ChampionDao
import com.sb.park.data.room.LOLDataBase
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
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
    fun provideMoshi(): Moshi = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()

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
}