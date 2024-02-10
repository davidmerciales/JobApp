package com.example.jobapp.domain.repository.job

import com.example.jobapp.domain.model.response.JobListResponse

interface JobRepository {
    suspend fun getJobList(): JobListResponse
}