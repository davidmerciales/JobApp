package com.example.jobapp.ui.screens.dashboard

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun JobInfo(
    index: Int,
    jobTitle: String = "",
    company: String = "",
    location: String = "",
    datePosted: String = "",
    img: String = "https://cdn-icons-png.flaticon.com/128/14827/14827635.png"
) {
    val context = LocalContext.current

    var isFavorite by remember {
        mutableStateOf(false)
    }

    Card(
        modifier = Modifier
            .fillMaxWidth(0.95f)
            .clickable {
                Toast.makeText(context, "$index index is Clicked", Toast.LENGTH_SHORT)
                    .show()
            },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )
    ) {

        Row(
            modifier = Modifier
                .background(Color(0xFFf5f5f5))
                .padding(10.dp)
                .fillMaxSize(),
        ) {

            AsyncImage(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .size(60.dp),
                model = img,
                contentScale = ContentScale.FillBounds,
                contentDescription = "company_icon",
            )

            Column(
                modifier = Modifier
                    .weight(0.65f)
                    .padding(vertical = 5.dp, horizontal = 15.dp),
                horizontalAlignment = Alignment.Start
            ) {

                Text(
                    text = jobTitle,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    style = TextStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                    )
                )

                Text(
                    text = company,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 18.sp
                    )
                )

                Text(
                    text = location,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    style = TextStyle(
                        color = Color.Gray,
                        fontSize = 15.sp
                    )
                )

                Spacer(modifier = Modifier.height(7.dp))

                Text(
                    text = datePosted,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    style = TextStyle(
                        color = Color(0xFF22733D),
                        fontSize = 13.sp
                    )
                )
            }

            Icon(
                modifier = Modifier
                    .weight(0.05f)
                    .clickable {
                        isFavorite = !isFavorite
                    },
                imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                tint = if (isFavorite) Color.Red else Color.Gray,
                contentDescription = "Favorite"
            )
        }
    }
}