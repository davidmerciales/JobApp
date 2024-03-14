package com.example.jobapp.ui.screens.dashboard

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun DrawerContent() {
    Box(
        modifier = Modifier.padding(start = 10.dp),
    ) {
        AsyncImage(
            modifier = Modifier
                .size(55.dp),
            model = "https://static-00.iconduck.com/assets.00/profile-circle-icon-2048x2048-cqe5466q.png",
            contentScale = ContentScale.FillBounds,
            contentDescription = "company_icon",
        )
    }

    Spacer(modifier = Modifier.width(15.dp))

    Column(
        modifier = Modifier
            .padding(top = 10.dp, bottom = 20.dp)
            .fillMaxWidth()
            .clickable {
            }
    ) {
        Text(
            modifier = Modifier.padding(start = 10.dp),
            text = "Juan Dela Cruz",
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            style = TextStyle(
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp,
            )
        )
        Text(
            modifier = Modifier.padding(start = 10.dp),
            text = "View profile",
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            style = TextStyle(
                color = Color.Black,
                fontWeight = FontWeight.Normal,
                fontSize = 15.sp,
            )
        )
    }
    Spacer(modifier = Modifier.height(15.dp))

    HorizontalDivider(
        thickness = 1.dp
    )

    Spacer(modifier = Modifier.height(15.dp))

    Box(modifier = Modifier
        .fillMaxWidth()
        .clickable {
        }) {
        Text(
            modifier = Modifier
                .padding(20.dp),
            text = "Help",
            style = TextStyle(
                fontSize = 25.sp
            )
        )
    }
    Box(modifier = Modifier
        .fillMaxWidth()
        .clickable {
        }) {
        Text(
            modifier = Modifier
                .padding(20.dp),
            text = "Settings",
            style = TextStyle(
                fontSize = 25.sp
            )
        )
    }
}