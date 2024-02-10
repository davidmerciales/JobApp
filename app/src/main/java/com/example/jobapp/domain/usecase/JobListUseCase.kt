package com.example.jobapp.domain.usecase

import com.example.jobapp.domain.model.response.JobListResponse
import com.example.jobapp.domain.repository.job.JobRepository
import javax.inject.Inject

class JobListUseCase @Inject constructor(
    private val jobRepository: JobRepository
) {

    suspend operator fun invoke(): JobListResponse{
        return jobRepository.getJobList()
    }
}