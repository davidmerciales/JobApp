package com.example.jobapp

 import android.os.Bundle
 import androidx.activity.ComponentActivity
 import androidx.activity.compose.setContent
 import androidx.navigation.compose.NavHost
 import androidx.navigation.compose.composable
 import androidx.navigation.compose.rememberNavController
 import com.example.jobapp.ui.navigation.AppController
 import com.example.jobapp.ui.screens.dashboard.Dashboard
 import com.example.jobapp.ui.theme.JobAppTheme
 import com.example.jobapp.utils.Routes
 import dagger.hilt.android.AndroidEntryPoint
 import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var appController: AppController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JobAppTheme {
                val navController = rememberNavController()
                appController.navController = navController

                NavHost(
                    navController = navController,
                    startDestination = Routes.Dashboard
                ){

                    composable(Routes.Dashboard){
                        Dashboard()
                    }

                }
            }
        }
    }
}