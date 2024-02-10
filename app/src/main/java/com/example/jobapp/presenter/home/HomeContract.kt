package com.example.jobapp.presenter.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.jobapp.domain.model.response.Jobs

class HomeContract {

    sealed interface HomeEvent {
    }

    interface HomeState {
        var jobs: List<Jobs>
    }

    class MutableHomeState: HomeState {
        override var jobs: List<Jobs> by mutableStateOf(emptyList())
    }
}