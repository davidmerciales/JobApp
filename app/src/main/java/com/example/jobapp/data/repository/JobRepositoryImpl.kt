package com.example.jobapp.data.repository

import com.example.jobapp.data.api.ApiService
import com.example.jobapp.domain.JobRepository
import javax.inject.Inject

class JobRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : JobRepository{

}