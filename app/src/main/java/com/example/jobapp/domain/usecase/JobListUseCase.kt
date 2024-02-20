package com.example.jobapp.domain.usecase

import com.example.jobapp.domain.model.Either
import com.example.jobapp.domain.model.Failure
import com.example.jobapp.domain.model.Success
import com.example.jobapp.domain.model.request.JobListRequest
import com.example.jobapp.domain.model.response.JobListResponse
import com.example.jobapp.domain.model.response.Jobs
import com.example.jobapp.domain.repository.job.JobRepository
import javax.inject.Inject
import kotlin.Exception

class JobListUseCase @Inject constructor(
    private val jobRepository: JobRepository
): UseCase<List<Jobs>, JobListRequest>() {

    override suspend fun run(params: JobListRequest): Either<Exception, List<Jobs>> {
        return try {
            val response = jobRepository.getJobList(params)
            Success(response.jobs)
        } catch (e: Exception){
            Failure(e)
        }
    }
}