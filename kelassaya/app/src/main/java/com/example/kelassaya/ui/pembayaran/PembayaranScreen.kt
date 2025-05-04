package com.example.kelassaya.ui.pembayaran

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PembayaranScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detail Pembayaran") },
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
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text("Kelas Premium: Fundamental Affiliate Marketing", fontSize = 20.sp)
                Spacer(modifier = Modifier.height(16.dp))
                Text("Metode Pembayaran: QRIS")
                Spacer(modifier = Modifier.height(16.dp))
                Text("Harga Kelas: Rp150.000")
                Spacer(modifier = Modifier.height(8.dp))
                Text("Biaya Transaksi: Rp1.000")
                Spacer(modifier = Modifier.height(8.dp))
                Text("Total: Rp151.000", fontSize = 18.sp, fontWeight = androidx.compose.ui.text.font.FontWeight.Bold)
            }

            Button(
                onClick = {
                    navController.navigate("qr_pembayaran")
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Bayar Sekarang")
            }
        }
    }
}
