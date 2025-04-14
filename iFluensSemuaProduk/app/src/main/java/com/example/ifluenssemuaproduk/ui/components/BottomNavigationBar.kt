package com.example.ifluenssemuaproduk.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun BottomNavigationBar() {
    NavigationBar {
        NavigationBarItem(
            selected = false,
            onClick = { /* TODO: Navigasi ke Beranda */ },
            icon = { Icon(Icons.Default.Home, contentDescription = "Beranda") },
            label = { Text("Beranda") }
        )
        NavigationBarItem(
            selected = false,
            onClick = { /* TODO: Navigasi ke Kelas */ },
            icon = { Icon(Icons.AutoMirrored.Filled.List, contentDescription = "Kelas") },
            label = { Text("Kelas") }
        )
        NavigationBarItem(
            selected = true, // ini yang sedang aktif
            onClick = { /* kosong karena sudah di halaman ini */ },
            icon = {
                Icon(Icons.Filled.ShoppingCart, contentDescription = "Produk")
            },
            label = { Text("Produk") },
            alwaysShowLabel = true
        )
        NavigationBarItem(
            selected = false,
            onClick = { /* TODO: Navigasi ke Obrolan */ },
            icon = { Icon(Icons.Filled.Email, contentDescription = "Obrolan") },
            label = { Text("Obrolan") }
        )
        NavigationBarItem(
            selected = false,
            onClick = { /* TODO: Navigasi ke Profil */ },
            icon = { Icon(Icons.Default.Person, contentDescription = "Profil") },
            label = { Text("Profil") }
        )
    }
}
