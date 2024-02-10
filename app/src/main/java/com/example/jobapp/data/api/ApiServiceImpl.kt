package com.example.jobapp.data.api

import com.example.jobapp.data.utils.Constants.BASE_URL
import com.example.jobapp.domain.model.response.JobListResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.client.request.parameter
import io.ktor.http.parameters
import javax.inject.Inject

class ApiServiceImpl @Inject constructor(
    private val httpClient: HttpClient
): ApiService {
    override suspend fun getJobList(): JobListResponse {
        val response = httpClient.get("$BASE_URL/list"){
            headers{
                append("X-RapidAPI-Key", "3bb6e57195msh49117cbc0e3734bp109120jsn066900d51b81")
                append("X-RapidAPI-Host", "jobs-api14.p.rapidapi.com")
            }
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