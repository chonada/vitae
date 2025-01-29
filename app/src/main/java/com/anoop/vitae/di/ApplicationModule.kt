package com.anoop.vitae.di

import com.anoop.common.buildconfig.BuildConfigFieldsProvider
import com.anoop.vitae.util.ApplicationBuildConfigFieldsProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface ApplicationModule {
    @Provides
    fun provideBuildConfigFieldsProvider(
        buildConfigFieldsProvider: ApplicationBuildConfigFieldsProvider
    ): BuildConfigFieldsProvider = buildConfigFieldsProvider
}