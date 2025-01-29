package com.anoop.data.di

import com.anoop.common.buildconfig.BuildConfigFieldsProvider
import com.anoop.data.respository.ResumeRepository
import com.anoop.data.respository.ResumeRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Provides
    @Singleton
    fun providesNetworkJson(): Json = Json {
        ignoreUnknownKeys = true
    }

    @Provides
    @Singleton
    fun okHttpCallFactory(
        buildConfigFieldsProvider: BuildConfigFieldsProvider
    ): Call.Factory = OkHttpClient.Builder()
        .addInterceptor(
            HttpLoggingInterceptor()
                .apply {
                    if (buildConfigFieldsProvider.get().buildType == "debug") {
                        setLevel(HttpLoggingInterceptor.Level.BODY)
                    }
                },
        )
        .build()
}