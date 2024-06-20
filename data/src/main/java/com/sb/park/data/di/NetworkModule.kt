package com.sb.park.data.di

import com.sb.park.data.DataDragon
import com.sb.park.data.service.DataDragonService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private val httpLoggingInterceptor = HttpLoggingInterceptor {
        Timber.e(it)
    }.setLevel(HttpLoggingInterceptor.Level.BASIC)

    private const val TIME_OUT = 30L

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor)
        .callTimeout(TIME_OUT, TimeUnit.SECONDS)
        .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
        .readTimeout(TIME_OUT, TimeUnit.SECONDS)
        .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
        .build()

    /**
     * DataDragon API
     */

    @Provides
    @Singleton
    @DataDragonRetrofit
    fun provideDataDragonRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(DataDragon.CHAMPION_BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideChampionService(@DataDragonRetrofit retrofit: Retrofit): DataDragonService =
        retrofit.create(DataDragonService::class.java)

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    private annotation class DataDragonRetrofit

    /**
     * Riot API
     */

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    private annotation class RiotRetrofit
}