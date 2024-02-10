package com.example.jobapp.data.di

import com.example.jobapp.data.api.ApiService
import com.example.jobapp.data.repository.JobRepositoryImpl
import com.example.jobapp.domain.repository.job.JobRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideJobRepository(apiService: ApiService) : JobRepository{
        return JobRepositoryImpl(apiService)
    }
}