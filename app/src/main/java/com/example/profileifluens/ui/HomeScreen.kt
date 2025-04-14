package com.example.profileifluens.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.profileifluens.R

@Composable
fun HomeScreen(navController: NavHostController) {

    val scrollState = rememberScrollState()
    Box(

        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            // Header with gradient background
            Spacer(modifier = Modifier.height(50.dp))

            Header()

            // Stats section
            StatsSection()
            
            // Special offer section
            SpecialOfferSection()
            
            // Continue module section
            ContinueModuleSection()
            
            // Featured products section
            FeaturedProductsSection()
            
            // Spacer at the bottom for bottom navigation bar
            Spacer(modifier = Modifier.height(80.dp))
        }
        
        // Bottom navigation bar
        BottomNavigationBar(
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun Header() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF3F51B5),
                        Color(0xFF7E57C2)
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Welcome Back !",
                    color = Color.White,
                    fontSize = 16.sp
                )
                
                Icon(
                    painter = painterResource(id = R.drawable.bell),
                    contentDescription = "Notifications",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
            }
            
            Text(
                text = "Riyan Fauzi",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 8.dp)
            )
            
            // Search bar
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White.copy(alpha = 0.9f)
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.search),
                        contentDescription = "Search",
                        tint = Color.Gray,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Cari Apa Saja",
                        color = Color.Gray,
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}

@Composable
fun StatsSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        StatCard(
            title = "Poin",
            value = "1000",
            backgroundColor = Color(0xFFE6E1F9),
            iconId = R.drawable.award,
            modifier = Modifier.weight(1f)
        )
        
        Spacer(modifier = Modifier.width(8.dp))
        
        StatCard(
            title = "Product Showcase",
            value = "100",
            backgroundColor = Color(0xFFE1F9E7),
            iconId = null,
            modifier = Modifier.weight(1f)
        )
        
        Spacer(modifier = Modifier.width(8.dp))
        
        StatCard(
            title = "Modul",
            value = "100",
            backgroundColor = Color(0xFFF9E1E1),
            iconId = null,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun StatCard(
    title: String,
    value: String,
    backgroundColor: Color,
    iconId: Int?,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .height(100.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = title,
                fontSize = 14.sp,
                color = Color.DarkGray
            )
            
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = value,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                
                if (iconId != null) {
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(
                        painter = painterResource(id = iconId),
                        contentDescription = null,
                        tint = Color(0xFF673AB7),
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun SpecialOfferSection() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(120.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF3F51B5)
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Today's Special",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                
                Text(
                    text = "Dapatkan diskon setiap pembelian kelas. Hanya untuk hari ini!",
                    fontSize = 12.sp,
                    color = Color.White,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
            
            Text(
                text = "40%",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}

@Composable
fun ContinueModuleSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Lanjutkan Modul",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Module card
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 4.dp
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                // Module header
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                        .background(
                            color = Color(0xFF192A56)
                        )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Learn how to earn",
                            color = Color.White,
                            fontSize = 16.sp
                        )
                        
                        Text(
                            text = "Affiliate Marketing",
                            color = Color(0xFFFFC312),
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(top = 8.dp)
                        )
                        
                        Text(
                            text = "Know how to promote product of many different company and earn commissions from them",
                            color = Color.White,
                            fontSize = 12.sp,
                            modifier = Modifier.padding(top = 16.dp)
                        )
                    }
                }
                
                // Module details
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Fundamental Affiliate Marketing",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.star),
                            contentDescription = null,
                            tint = Color(0xFFFFC312),
                            modifier = Modifier.size(16.dp)
                        )
                        
                        Text(
                            text = "4.9",
                            fontSize = 14.sp,
                            color = Color.Black,
                            modifier = Modifier.padding(start = 4.dp, end = 16.dp)
                        )
                        
                        Icon(
                            painter = painterResource(id = R.drawable.users),
                            contentDescription = null,
                            tint = Color.Gray,
                            modifier = Modifier.size(16.dp)
                        )
                        
                        Text(
                            text = "127 Peserta",
                            fontSize = 14.sp,
                            color = Color.Gray,
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    }
                    
                    // Progress bar
                    LinearProgressIndicator(
                        progress = 0.6f,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        color = Color(0xFF2ECC71),
                        trackColor = Color(0xFFEEEEEE)
                    )
                    
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "",
                            fontSize = 14.sp,
                            color = Color.Gray
                        )
                        
                        Text(
                            text = "60%",
                            fontSize = 14.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    
                    Button(
                        onClick = { /* No-op */ },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF2ECC71)
                        )
                    ) {
                        Text(
                            text = "Lanjutkan",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun FeaturedProductsSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Produk Unggulan",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            
            Text(
                text = "Selengkapnya",
                fontSize = 14.sp,
                color = Color(0xFF7E57C2)
            )
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Category tabs
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            val categories = listOf("Semua", "Fashion", "Lifestyle", "Home Decor")
            items(categories) { category ->
                CategoryChip(
                    category = category,
                    isSelected = category == "Semua"
                )
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Products grid (shown as row in this example, can be converted to grid)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            ProductCard(
                imageId = R.drawable.image,
                title = "Baju Koko Lebaran Cowo All Size SlimFit",
                price = "Rp 100.000",
                commission = "Earn Rp5.000",
                modifier = Modifier.weight(1f)
            )
            
            ProductCard(
                imageId = R.drawable.image,
                title = "Baju Koko Lebaran Cowo All Size SlimFit",
                price = "Rp 100.000",
                commission = "Earn Rp5.000",
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun CategoryChip(
    category: String,
    isSelected: Boolean
) {
    Surface(
        shape = RoundedCornerShape(24.dp),
        color = if (isSelected) Color(0xFF7E57C2) else Color(0xFFEEEEEE)
    ) {
        Text(
            text = category,
            color = if (isSelected) Color.White else Color.Gray,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            fontSize = 14.sp
        )
    }
}

@Composable
fun ProductCard(
    imageId: Int,
    title: String,
    price: String,
    commission: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        // Product image
        Image(
            painter = painterResource(id = imageId),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )
        
        // Product details
        Text(
            text = title,
            fontSize = 14.sp,
            color = Color.Black,
            modifier = Modifier.padding(top = 8.dp),
            maxLines = 2
        )
        
        Text(
            text = commission,
            fontSize = 12.sp,
            color = Color(0xFFE91E63),
            modifier = Modifier.padding(top = 4.dp)
        )
        
        Text(
            text = price,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(top = 4.dp)
        )
        
        Button(
            onClick = { /* No-op */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF3F51B5)
            )
        ) {
            Text(
                text = "Pengajuan Afiliasi",
                fontSize = 12.sp,
                color = Color.White
            )
        }
    }
}

@Composable
fun BottomNavigationBar(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(80.dp),
        color = Color.White,
        shadowElevation = 8.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BottomNavItem(
                iconId = R.drawable.home,
                title = "Beranda",
                isSelected = true
            )
            
            BottomNavItem(
                iconId = R.drawable.book_open,
                title = "Kelas"
            )
            
            BottomNavItem(
                iconId = R.drawable.product,
                title = "Produk"
            )
            
            BottomNavItem(
                iconId = R.drawable.chat,
                title = "Obrolan"
            )
            
            BottomNavItem(
                iconId = R.drawable.profile,
                title = "Profile"
            )
        }
    }
}

@Composable
fun BottomNavItem(
    iconId: Int,
    title: String,
    isSelected: Boolean = false
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = iconId),
            contentDescription = title,
            tint = if (isSelected) Color(0xFF7E57C2) else Color.Gray,
            modifier = Modifier.size(24.dp)
        )
        
        Spacer(modifier = Modifier.height(4.dp))
        
        Text(
            text = title,
            fontSize = 12.sp,
            color = if (isSelected) Color(0xFF7E57C2) else Color.Gray,
            textAlign = TextAlign.Center
        )
    }
}

