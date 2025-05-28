package com.example.kelassaya.ui.kelas

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.kelassaya.model.KelasModel
import com.example.kelassaya.model.dummyKelasList
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Add


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KelasScreen(navController: NavController) {
    var selectedTab by remember { mutableStateOf("ongoing") }

    val ongoingKelas = remember { dummyKelasList.filter { !it.isCompleted } }
    val completedKelas = remember { dummyKelasList.filter { it.isCompleted } }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate("tambah_kelas") }) {
                Icon(Icons.Default.Add, contentDescription = "Tambah Kelas")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            // Header
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Kelas Saya", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                IconButton(onClick = { /* TODO: open search */ }) {
                    Icon(Icons.Default.Search, contentDescription = "Search")
                }
            }

            // Tab
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    "On Going",
                    modifier = Modifier.clickable { selectedTab = "ongoing" },
                    fontWeight = if (selectedTab == "ongoing") FontWeight.Bold else FontWeight.Normal
                )
                Text(
                    "Completed",
                    modifier = Modifier.clickable { selectedTab = "completed" },
                    fontWeight = if (selectedTab == "completed") FontWeight.Bold else FontWeight.Normal
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // List
            LazyColumn(modifier = Modifier.weight(1f)) {
                val data = if (selectedTab == "ongoing") ongoingKelas else completedKelas
                items(data) { kelas ->
                    KelasCard(kelas = kelas, navController = navController, selectedTab = selectedTab)
                }
            }
        }
    }
}

@Composable
fun KelasCard(kelas: KelasModel, navController: NavController, selectedTab: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable {
                if (kelas.isUnlocked) navController.navigate("detail_kelas")
                else if (kelas.isPremium) navController.navigate("pembayaran")
            }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(kelas.title, fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
            Text("${kelas.tanggal} · ⭐ ${kelas.rating} · 👥 ${kelas.peserta} Peserta")

            if (selectedTab == "ongoing") {
                LinearProgressIndicator(
                    progress = kelas.progress / 100f,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp)
                )
            }

            if (selectedTab == "completed") {
                Button(
                    onClick = {
                        if (!kelas.hasFeedback) navController.navigate("feedback")
                    },
                    modifier = Modifier.padding(top = 8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (kelas.hasFeedback)
                            MaterialTheme.colorScheme.primary
                        else
                            MaterialTheme.colorScheme.secondary
                    )
                ) {
                    Text(if (kelas.hasFeedback) "Done" else "Feedback")
                }
            }
        }
    }
}
