package com.example.ifluenssemuaproduk.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ifluenssemuaproduk.R
import com.example.ifluenssemuaproduk.navigation.Screen
import androidx.compose.ui.Alignment
import androidx.compose.material.icons.filled.Search


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Produk", // Judul di tengah
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {
                        // TODO: aksi pencarian
                    }) {
                        Icon(Icons.Default.Search, contentDescription = "Cari")
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        bottomBar = {
            Button(
                onClick = { navController.navigate(Screen.AffiliateLink.route) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text("Pengajuan Afiliasi")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            // Pastikan kamu memiliki gambar dengan ID 'baju_koko' di folder drawable
            Image(
                painter = painterResource(id = R.drawable.baju_koko),
                contentDescription = "Product Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .padding(bottom = 16.dp),
                contentScale = ContentScale.Crop
            )

            Text(
                text = "Baju Koko Lebaran Cowo All Size SlimFit...",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                maxLines = 2
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Earn Rp5.000",
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Rp 100.000",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(text = "Terjual 54")

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Detail produk",
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Lorem ipsum dolor sit amet Lorem ipsum dolor sit amet Lorem ipsum dolor sit amet Lorem ipsum dolor sit amet Lorem ipsum dolor sit amet Lorem ipsum dolor sit amet Lorem ipsum dolor sit amet Lorem ipsum dolor sit amet Lorem ipsum dolor sit amet Lorem ipsum dolor sit amet Lorem ipsum dolor sit amet Lorem ipsum dolor sit amet Lorem ipsum dolor sit amet Lorem ipsum dolor sit amet.",
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}
