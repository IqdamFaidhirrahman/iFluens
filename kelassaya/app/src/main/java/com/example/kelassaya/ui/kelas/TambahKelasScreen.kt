package com.example.kelassaya.ui.kelas

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.kelassaya.model.KelasModel
import com.example.kelassaya.model.dummyKelasList
import androidx.compose.material.icons.filled.Search

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TambahKelasScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Tambah Kelas") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Kembali")
                    }
                },
                actions = {
                    IconButton(onClick = { /* TODO: Search action */ }) {
                        Icon(Icons.Default.Search, contentDescription = "Search")
                    }
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            items(dummyKelasList) { kelas ->
                KelasTambahItem(kelas = kelas, onTambahClick = {
                    // Logika tambah kelas atau pembelian premium
                    if (kelas.isPremium && !kelas.isUnlocked) {
                        navController.navigate("pembayaran")
                    } else {
                        navController.popBackStack() // kembali setelah ditambah
                    }
                })
            }
        }
    }
}

@Composable
fun KelasTambahItem(kelas: KelasModel, onTambahClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
            .background(if (kelas.isPremium) Color.LightGray else Color.Transparent)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(kelas.title, fontSize = 16.sp)
                Text("${kelas.tanggal} · ⭐ ${kelas.rating} · 👥 ${kelas.peserta} Peserta")
                if (kelas.isPremium) Text("Kelas Premium", color = Color.Red, fontSize = 12.sp)
            }
            IconButton(onClick = onTambahClick) {
                Icon(Icons.Default.Add, contentDescription = "Tambah")
            }
        }
    }
}
