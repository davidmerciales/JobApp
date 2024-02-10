package com.example.jobapp.presenter.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jobapp.domain.usecase.JobListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val jobListUseCase: JobListUseCase
): ViewModel() {
    init {
        viewModelScope.launch {
            jobListUseCase.invoke().jobs
        }
    }
}