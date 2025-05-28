package com.example.ifluenssemuaproduk.ui.screens

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.horizontalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack

import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ifluenssemuaproduk.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AffiliateLinkScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Produk", fontWeight = FontWeight.Bold)
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = {
                        // TODO: Aksi pencarian
                    }) {
                        Icon(Icons.Filled.Search, contentDescription = "Cari")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            // Bagian pertama: Foto produk, Nama dan Harga
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.baju_koko),
                    contentDescription = "Product Image",
                    modifier = Modifier
                        .size(80.dp)
                        .padding(end = 16.dp)
                )

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Baju Koko", fontWeight = FontWeight.Bold)
                    Text("Rp 100.000", style = MaterialTheme.typography.bodyLarge)
                }
            }

            // Garis horizontal pemisah
            Divider(modifier = Modifier.padding(vertical = 16.dp))

            // Bagian kedua: Jumlah Uang yang Didapat dan Nominal Komisi
            Text("Jumlah uang yang didapat", fontWeight = FontWeight.Bold)
            Text(
                "Rp 5.000", // Komisi yang didapat
                color = Color.Red,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold
            )

            // Garis horizontal pemisah
            Divider(modifier = Modifier.padding(vertical = 16.dp))

            // Bagian ketiga: Link Afiliasi dan tombol salin
            Text("Link Afiliasi", fontWeight = FontWeight.Bold)
            Row(verticalAlignment = Alignment.CenterVertically) {
                // Link afiliasi memanjang dan dapat digulir secara horizontal
                BasicText(
                    text = "www.afiliasi.com/produk_baju_koko_sangat_panjang_untuk_ditampilkan",
                    modifier = Modifier
                        .weight(1f)
                        .horizontalScroll(rememberScrollState())
                )

                Button(
                    onClick = { copyToClipboard("www.afiliasi.com/produk_baju_koko_sangat_panjang_untuk_ditampilkan", navController.context) },
                    modifier = Modifier.padding(start = 8.dp)
                ) {
                    Text("Salin")
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            // Tombol Setuju
            Button(
                onClick = {
                    // TODO: Implement Setuju action
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            ) {
                Text("Setuju")
            }
        }
    }
}

// Fungsi untuk menyalin teks ke clipboard
fun copyToClipboard(text: String, context: Context) {
    val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    val clip = ClipData.newPlainText("Affiliate Link", text)
    clipboard.setPrimaryClip(clip)
}
