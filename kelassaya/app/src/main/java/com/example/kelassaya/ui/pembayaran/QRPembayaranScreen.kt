package com.example.kelassaya.ui.pembayaran

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.app.R
import androidx.compose.foundation.background

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QRPembayaranScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("QR Pembayaran") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Kembali")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(modifier = Modifier.height(16.dp))
                Text("Scan QR dengan aplikasi e-wallet", fontSize = 16.sp)
                Spacer(modifier = Modifier.height(16.dp))
                Box(
                    modifier = Modifier
                        .size(200.dp)
                        .background(Color.LightGray),
                    contentAlignment = Alignment.Center
                ) {
                    Text("[QR IMAGE]", color = Color.DarkGray)
                    // Ganti dengan Image jika punya resource: Image(painterResource(id = R.drawable.qr_code), ...)
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text("Selesaikan pembayaran dalam 1 menit", color = Color.Red, fontSize = 12.sp)
            }

            Column {
                Button(
                    onClick = { /* Upload bukti, tidak diterapkan */ },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Upload Bukti Pembayaran")
                }
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = {
                        // Setelah konfirmasi, kembali ke halaman utama kelas
                        navController.navigate("kelas") {
                            popUpTo("kelas") { inclusive = true }
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
                ) {
                    Text("Konfirmasi Pembayaran")
                }
            }
        }
    }
}