package com.example.jobapp.data.api

import com.example.jobapp.data.utils.Constants.BASE_URL
import com.example.jobapp.domain.model.response.JobListResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.parameters
import javax.inject.Inject

class ApiServiceImpl @Inject constructor(
    private val httpClient: HttpClient
): ApiService {
    override suspend fun getJobList(): JobListResponse {
        val response = httpClient.get("$BASE_URL/list"){
            parameters{
                parameter("query", "Web%20Developer")
                parameter("location", "United%20States")
                parameter("distance", "1.0")
                parameter("language", "en_GB")
                parameter("remoteOnly", "false")
                parameter("datePosted", "month")
                parameter("emplyomentTypes", "fulltime%3Bparttime%3Bintern%3Bcontractor")
                parameter("index", "0")
            }
        }

        return response.body()
    }
}