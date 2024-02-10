package com.example.jobapp.domain.model.response

data class JobListResponse(
    val jobs: List<Jobs> = emptyList(),
    val index: Int = 0,
    val jobCount: Int = 0,
    val hasError: Boolean = false,
    val errors: List<String> = emptyList()
)

data class Jobs(
    val id: String = "",
    val title: String = "",
    val company: String = "",
    val description: String = "",
    val image: String = "",
    val location: String = "",
    val employmentType: String = "",
    val datePosted: String = "",
    val salaryRange: String = "",
    val jobProviders: List<JobProviders> = emptyList()
)
data class JobProviders(
    val jobProviders: String = "",
    val url: String = ""
)
