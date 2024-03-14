package com.example.jobapp.ui.screens.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.jobapp.domain.model.response.Jobs

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardContent(
    jobList: List<Jobs> = emptyList(),
    searchText: String = "",
    onSearchTextChange: (String) -> Unit,
    onToggleSearch: (Boolean) -> Unit,
    isSearching: Boolean = false,
) {
    Column(
        modifier = Modifier
            .padding(top = 30.dp)
    ) {

        Row(
            modifier = Modifier
                .background(Color(0XFF2e3787))
                .fillMaxWidth()
                .padding(vertical = 25.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Spacer(modifier = Modifier.width(10.dp))

            Box(
                modifier = Modifier
                    .background(Color.Gray, RoundedCornerShape(50.dp))
            ) {

                AsyncImage(
                    modifier = Modifier
                        .size(45.dp),
                    model = "https://static-00.iconduck.com/assets.00/profile-circle-icon-2048x2048-cqe5466q.png",
                    contentScale = ContentScale.FillBounds,
                    contentDescription = "company_icon",
                )
            }

            Spacer(modifier = Modifier.width(15.dp))

            Column(
                modifier = Modifier
                    .weight(0.6f)
            ) {
                Text(
                    text = "Juan Dela Cruz",
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    style = TextStyle(
                        color = Color(0XFFe1e4ef),
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp,
                    )
                )
                Text(
                    text = "Software Developer",
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    style = TextStyle(
                        color = Color(0XFFe1e4ef),
                        fontWeight = FontWeight.Normal,
                        fontSize = 15.sp,
                    )
                )
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        SearchBar(
            query = searchText,
            onQueryChange = { onSearchTextChange(it) },
            onSearch = { onSearchTextChange(it) },
            active = isSearching,
            onActiveChange = { onToggleSearch(it) },
            colors = SearchBarDefaults.colors(
                containerColor = Color.White
            ),
            placeholder = { Text(text = "Search") },
            trailingIcon = {
                Icon(
                    modifier = Modifier.clickable { },
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search"
                )
            },
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            LazyColumn {
                items(jobList) { jobs ->
                    Text(
                        text = jobs.company,
                        modifier = Modifier.padding(
                            start = 8.dp,
                            top = 4.dp,
                            end = 8.dp,
                            bottom = 4.dp
                        )
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(15.dp))

        Text(
            modifier = Modifier
                .padding(start = 10.dp),
            text = "Suggested for you:",
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            style = TextStyle(
                color = Color.DarkGray,
                fontWeight = FontWeight.Normal,
                fontSize = 15.sp,
            )
        )

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(vertical = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            itemsIndexed(jobList) { index, item ->
                JobInfo(
                    index,
                    item.title,
                    item.company,
                    item.location,
                    item.datePosted,
                    item.image
                )

                Spacer(modifier = Modifier.height(7.dp))
            }
        }
    }
}