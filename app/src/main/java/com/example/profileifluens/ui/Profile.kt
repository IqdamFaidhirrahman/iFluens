package com.example.profileifluens.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.*
import androidx.navigation.NavHostController
import com.example.profileifluens.R

@Composable
fun ProfileScreen(navController: NavHostController) {
    Scaffold(
        bottomBar = { BottomNavBar() },
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color(0xFFF9F9F9))
        ) {
            Text(
                text = "Profile",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1E1E1E),
                modifier = Modifier.padding(16.dp)
            )

            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.avatar_placeholder),
                    contentDescription = "Avatar",
                    modifier = Modifier
                        .size(64.dp)
                        .clip(CircleShape)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(
                        text = "Riyan Fauzi",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp
                    )
                    Text(
                        text = "Lorem ipsum dolor sit am...",
                        fontSize = 14.sp,
                        color = Color.Gray,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Card(
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth(),
                elevation = 4.dp
            ) {
                Column {
                    MenuItem(title = "Akun") {
                        navController.navigate("account_detail")
                    }
                    MenuItem(title = "Notifikasi") {
                        navController.navigate("notification")
                    }
                    MenuItem(title = "Password dan keamanan") {
                        navController.navigate("password")
                    }
                    MenuItem(title = "Tentang") { }
                    MenuItem(title = "Kebijakan privasi") { }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Card(
                shape = RoundedCornerShape(12.dp),
                elevation = 2.dp,
                backgroundColor = Color.White,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Log out",
                    color = Color.Red,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(16.dp)
                        .clickable { /* handle logout */ }
                )
            }
        }
    }
}

@Composable
fun MenuItem(
    title: String,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = Color.Black
        )
    }
    Divider()
}

@Composable
fun BottomNavBar() {
    BottomNavigation(backgroundColor = Color.White) {
        BottomNavigationItem(
            icon = { Icon(Icons.Default.Home, contentDescription = null) },
            selected = false, onClick = {}, label = { Text("Beranda", fontSize = 10.sp) }
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Default.Book, contentDescription = null) },
            selected = false, onClick = {}, label = { Text("Kelas", fontSize = 10.sp) }
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Default.Wallet, contentDescription = null) },
            selected = false, onClick = {}, label = { Text("Produk", fontSize = 10.sp) }
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Default.ChatBubble, contentDescription = null) },
            selected = false, onClick = {}, label = { Text("Obrolan", fontSize = 10.sp) }
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Default.Person, contentDescription = null, tint = Color(0xFF8B5CF6)) },
            selected = true, onClick = {}, label = { Text("Profile", fontSize = 10.sp) }
        )
    }
}