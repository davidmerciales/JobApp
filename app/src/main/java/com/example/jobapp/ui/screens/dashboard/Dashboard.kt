package com.example.jobapp.ui.screens.dashboard

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jobapp.presenter.dashboard.DashboardContract
import com.example.jobapp.presenter.dashboard.DashboardViewModel

@SuppressLint("CoroutineCreationDuringComposition", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Dashboard(
    viewModel: DashboardViewModel = hiltViewModel(),
) {

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)


    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier
                    .width(250.dp)){

                Spacer(modifier = Modifier.height(25.dp))

                DrawerContent()
            }
        }) {
        Scaffold(
            topBar = {
                TopBarContent(drawerState)
            },
            content = {
                DashboardContent(
                    jobList = viewModel.state.jobs,
                    searchText = viewModel.state.searchText,
                    onSearchTextChange = {
                        viewModel.setEvent(
                            DashboardContract.HomeEvent.OnSearchTextChange(
                                it
                            )
                        )},
                    onToggleSearch = {
                        viewModel.setEvent(
                            DashboardContract.HomeEvent.OnToggleSearch(
                                it
                            )
                        )},
                    isSearching = viewModel.state.isSearching)
            }
        )
    }
}

