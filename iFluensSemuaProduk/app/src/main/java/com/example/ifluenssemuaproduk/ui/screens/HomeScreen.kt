package com.example.ifluenssemuaproduk.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ifluenssemuaproduk.model.Product
import com.example.ifluenssemuaproduk.ui.components.ProductCard
import com.example.ifluenssemuaproduk.ui.components.BottomNavigationBar
import com.example.ifluenssemuaproduk.navigation.Screen


@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun HomeScreen(navController: NavController) {
    val dummyProducts = listOf(
        Product(1, "Baju Koko", "Rp 100.000", "baju_koko", "10%", "Fashion"),
        Product(2, "Laptop", "Rp 150.000", "elektronik", "12%", "Elektronik"),
        Product(3, "Sabun Cuci Muka", "Rp 200.000", "kecantikan", "8%", "Kecantikan"),
        Product(4, "Bola Basket", "Rp 250.000", "olahraga", "15%", "Olahraga"),
    )

    val myProducts = listOf(
        Product(5, "Produk Saya 1", "Rp 300.000", "baju_koko", "20%", "Fashion"),
        Product(6, "Produk Saya 2", "Rp 350.000", "elektronik", "18%", "Elektronik")
    )

    val tabs = listOf("Semua Produk", "Produk Saya")
    var selectedTabIndex by remember { mutableStateOf(0) }

    val categories = listOf("Semua", "Fashion", "Elektronik", "Kecantikan", "Olahraga")
    var selectedCategory by remember { mutableStateOf("Semua") }

    val currentProducts = if (selectedTabIndex == 0) dummyProducts else myProducts
    val filteredProducts = if (selectedCategory == "Semua") currentProducts
    else currentProducts.filter { it.category == selectedCategory }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Produk Afiliasi") },
                actions = {
                    IconButton(onClick = {
                        // TODO: aksi pencarian
                    }) {
                        Icon(Icons.Default.Search, contentDescription = "Cari")
                    }
                }
            )
        },
        bottomBar = {
            BottomNavigationBar()
        }
    ) { innerPadding ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(horizontal = 16.dp)) {

            Spacer(modifier = Modifier.height(8.dp))

            // Tabs
            TabRow(selectedTabIndex = selectedTabIndex) {
                tabs.forEachIndexed { index, title ->
                    Tab(
                        selected = selectedTabIndex == index,
                        onClick = {
                            selectedTabIndex = index
                            selectedCategory = "Semua"
                        },
                        text = { Text(title) }
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Kategori
            LazyRow(
                contentPadding = PaddingValues(horizontal = 4.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(categories) { category ->
                    CategoryButton(category = category, isSelected = selectedCategory == category) {
                        selectedCategory = category
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Grid produk
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(bottom = 16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(filteredProducts) { product ->
                    ProductCard(product = product) {
                        navController.navigate(Screen.ProductDetail.route)
                    }
                }
            }
        }
    }
}

@Composable
fun CategoryButton(category: String, isSelected: Boolean, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface,
            contentColor = if (isSelected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurface
        ),
        shape = RoundedCornerShape(50),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 4.dp)
    ) {
        Text(text = category)
    }
}
