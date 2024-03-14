package com.example.jobapp.ui.screens.dashboard

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun TopBarContent(
    drawerState: DrawerState
) {

    val scope = rememberCoroutineScope()
    Row(
        modifier = Modifier
            .background(Color(0XFF2e3787))
            .padding(10.dp)
    ) {
        Box(
            modifier = Modifier
                .weight(0.7f)
        ) {
            Icon(
                modifier = Modifier
                    .clickable {
                        Log.d("Dashboard", drawerState.toString())
                        scope.launch {
                            drawerState.apply {
                                open()
                            }
                        }
                    },
                imageVector = Icons.Default.Menu,
                tint = Color.White,
                contentDescription = "Favorite"
            )
        }
        Icon(
            modifier = Modifier
                .weight(0.15f)
                .clickable {
                },
            imageVector = Icons.Default.Email,
            tint = Color.White,
            contentDescription = "Favorite"
        )
        Icon(
            modifier = Modifier
                .weight(0.08f)
                .clickable {
                },
            imageVector = Icons.Default.Notifications,
            tint = Color.White,
            contentDescription = "Favorite"
        )
    }
}