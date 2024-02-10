package com.example.jobapp.data.di

import com.example.jobapp.data.api.ApiService
import com.example.jobapp.data.repository.JobRepositoryImpl
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@dagger.Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    fun provideJobRepository(apiService: ApiService) : JobRepositoryImpl{
        return JobRepositoryImpl(apiService)
    }
}