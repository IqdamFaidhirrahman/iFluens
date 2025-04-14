package com.example.profileifluens.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.profileifluens.R

@Composable
fun NotificationScreen(navController: NavController) {
    val groupedNotifications = mapOf(
        "21 Maret 2025" to listOf(
            NotificationItem("Community: New Offer", "Lorem ipsum dolor sit am...", "20.22"),
            NotificationItem("Adam Himawan", "Lorem ipsum dolor sit am...", "13.22")
        ),
        "19 Maret 2025" to listOf(
            NotificationItem("New Product", "Lorem ipsum dolor sit am...", "18.22"),
            NotificationItem("Kelas Afiliasi", "Lorem ipsum dolor sit am...", "17.22")
        )
    )

    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                tint = Color(0xFF6D28D9),
                modifier = Modifier
                    .clickable { navController.popBackStack() }
                    .padding(end = 16.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text("Notifikasi", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }

        LazyColumn(modifier = Modifier.padding(horizontal = 16.dp)) {
            groupedNotifications.forEach { (date, items) ->
                item {
                    Text(
                        text = date,
                        style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Medium),
                        modifier = Modifier.padding(vertical = 12.dp)
                    )
                }
                items(items) { item ->
                    NotificationRow(item)
                    Divider()
                }
            }
        }
    }
}

@Composable
fun NotificationRow(item: NotificationItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.avatar_placeholder), // placeholder profile image
            contentDescription = null,
            modifier = Modifier
                .size(48.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(text = item.title, fontWeight = FontWeight.Bold)
            Text(text = item.subtitle, fontSize = 12.sp, color = Color.Gray)
        }
        Text(text = item.time, fontSize = 12.sp, color = Color.Gray)
    }
}

data class NotificationItem(val title: String, val subtitle: String, val time: String)
