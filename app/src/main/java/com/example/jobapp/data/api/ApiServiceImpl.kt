package com.example.jobapp.data.api

import io.ktor.client.HttpClient
import javax.inject.Inject

class ApiServiceImpl @Inject constructor(
    private val httpClient: HttpClient
): ApiService {
}