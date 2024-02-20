package com.example.jobapp.data.repository

import com.example.jobapp.data.api.ApiService
import com.example.jobapp.domain.model.request.JobListRequest
import com.example.jobapp.domain.model.response.JobListResponse
import com.example.jobapp.domain.repository.job.JobRepository
import javax.inject.Inject

class JobRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : JobRepository {
    override suspend fun getJobList(request: JobListRequest) = apiService.getJobList(request)

}