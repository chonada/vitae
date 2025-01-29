package com.anoop.data.di

import com.anoop.data.respository.ResumeRepository
import com.anoop.data.respository.ResumeRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun bindResumeRepository(resumeRepositoryImpl: ResumeRepositoryImpl): ResumeRepository
}