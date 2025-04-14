package com.example.ifluenssemuaproduk.model

data class Product(
    val id: Int,
    val name: String,
    val price: String,
    val imageUrl: String,
    val commission: String,
    val category: String
)

val dummyProductList = listOf(
    Product(
        id = 1,
        name = "Jam Tangan Kulit",
        imageUrl = "https://via.placeholder.com/150",
        price = "Rp 250.000",
        commission = "Rp 50.000",
        category = "Fashion"
    ),
    Product(
        id = 2,
        name = "Tas Rotan Handmade",
        imageUrl = "https://via.placeholder.com/150",
        price = "Rp 300.000",
        commission = "Rp 60.000",
        category = "Lifestyle"
    ),
    Product(
        id = 3,
        name = "Bantal Sofa Lucu",
        imageUrl = "https://via.placeholder.com/150",
        price = "Rp 120.000",
        commission = "Rp 25.000",
        category = "Home Decor"
    ),
    Product(
        id = 4,
        name = "Sepatu Sneakers Putih",
        imageUrl = "https://via.placeholder.com/150",
        price = "Rp 400.000",
        commission = "Rp 80.000",
        category = "Fashion"
    )
)
