package com.example.jobapp.data.api

import com.example.jobapp.domain.model.response.JobListResponse

interface ApiService {
    suspend fun getJobList(): JobListResponse
}