package com.example.jobapp.data.api

import com.example.jobapp.domain.model.request.JobListRequest
import com.example.jobapp.domain.model.response.JobListResponse

interface ApiService {
    suspend fun getJobList(request: JobListRequest): JobListResponse
}