package com.example.jobapp.domain.model.request

import kotlinx.serialization.Serializable


@Serializable
data class JobListRequest (
    var query: String = "",
    val location: String = "",
    val distance: String = "",
    val language: String = "",
    val remoteOnly: String = "",
    val datePosted: String = "",
    val employmentTypes: String = "",
    val index: String = ""
)