package com.example.jobapp.presenter.dashboard

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jobapp.domain.model.request.JobListRequest
import com.example.jobapp.domain.model.response.Jobs
import com.example.jobapp.domain.usecase.JobListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val jobListUseCase: JobListUseCase
) : ViewModel() {
    val state: DashboardContract.HomeState = DashboardContract.MutableHomeState()

    private val _event = MutableSharedFlow<DashboardContract.HomeEvent>()
    val event: SharedFlow<@UnsafeVariance DashboardContract.HomeEvent> = _event.asSharedFlow()

    init {
        viewModelScope.launch {
            getJobList()


            event.collect { event ->
                when (event) {

                    is DashboardContract.HomeEvent.OnSearchTextChange -> {
                        state.searchText = event.text
                    }

                    is DashboardContract.HomeEvent.OnToggleSearch -> {
                        state.isSearching = event.toggle
                    }
                }
            }
        }
    }

    private fun getJobList() {
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
                Log.d("Joblist", "Success!")
            },
            onFailure = {
                var jobs = mutableListOf<Jobs>()
                repeat(7) {
                    jobs.add(
                        Jobs(
                            id = "1",
                            title = "test_title_test_title",
                            company = "test_company",
                            description = "test_description",
                            image = "https://cdn-icons-png.flaticon.com/128/14827/14827635.png",
                            location = "test_location",
                            employmentType = "test_employment",
                            datePosted = "January 01, 1900",
                            salaryRange = "50,000 - 100,000",
                            jobProviders = emptyList()
                        ),)
                }
                state.jobs = jobs
            }
        )
    }

    fun setEvent(event: DashboardContract.HomeEvent) {
        val newEvent = event
        viewModelScope.launch { _event.emit(newEvent) }
    }
}