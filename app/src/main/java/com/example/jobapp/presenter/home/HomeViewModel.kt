package com.example.jobapp.presenter.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jobapp.domain.model.request.JobListRequest
import com.example.jobapp.domain.usecase.JobListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val jobListUseCase: JobListUseCase
): ViewModel() {
    val state: HomeContract.HomeState = HomeContract.MutableHomeState()
    init {
        viewModelScope.launch {
            jobListUseCase(
                params = JobListRequest(
                    query = "Web%20Developer",
                    location = "United%20States",
                    distance = "1.0",
                    language = "en_GB",
                    remoteOnly = "false",
                    datePosted = "month",
                    employmentTypes = "fulltime%3Bparttime%3Bintern%3Bcontractor",
                    index = "0"
                ),
                onSuccess = {
                    state.jobs = it
                },
                onFailure = {
                    Log.d("onFailure", "Failed")
                }
            )
        }
    }
}