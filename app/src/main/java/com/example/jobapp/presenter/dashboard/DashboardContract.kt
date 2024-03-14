package com.example.jobapp.presenter.dashboard

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.jobapp.domain.model.response.Jobs

class DashboardContract {

    sealed interface HomeEvent {
        data class OnSearchTextChange(var text: String) : HomeEvent
        data class OnToggleSearch(var toggle: Boolean) : HomeEvent
    }

    interface HomeState {
        var jobs: List<Jobs>
        var searchText: String
        var isSearching: Boolean
        var onSearchTextChange: String
        var onToogleSearch: Boolean
    }

    class MutableHomeState: HomeState {
        override var jobs: List<Jobs> by mutableStateOf(emptyList())
        override var searchText: String by mutableStateOf("")
        override var isSearching: Boolean by mutableStateOf(false)
        override var onSearchTextChange: String by mutableStateOf("")
        override var onToogleSearch: Boolean by mutableStateOf(false)
    }
}