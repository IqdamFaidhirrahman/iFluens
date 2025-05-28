package com.example.ifluenssemuaproduk.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.ifluenssemuaproduk.model.Product

@Composable
fun ProductCard(
    product: Product,
    onAffiliateClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            // Load image from local resources using painterResource
            val image = painterResource(id = when (product.imageUrl) {
                "baju_koko" -> com.example.ifluenssemuaproduk.R.drawable.baju_koko
                "elektronik" -> com.example.ifluenssemuaproduk.R.drawable.elektronik
                "kecantikan" -> com.example.ifluenssemuaproduk.R.drawable.kecantikan
                "olahraga" -> com.example.ifluenssemuaproduk.R.drawable.olahraga
                else -> com.example.ifluenssemuaproduk.R.drawable.kaos_polos // fallback
            })

            // Display the image
            Image(
                painter = image,
                contentDescription = product.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(120.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.height(10.dp))

            Text(text = product.name, style = MaterialTheme.typography.bodyLarge)
            // Menghitung komisi berdasarkan persentase dan harga produk
            val priceAmount = product.price.replace("Rp", "").replace(",", "").trim().toDoubleOrNull()
            val commissionAmount = priceAmount?.let {
                val percentage = product.commission.replace("%", "").toDoubleOrNull() ?: 0.0
                (it * percentage / 100).toInt()
            }
            commissionAmount?.let {
                Text(
                    text = "Earn Rp ${"%,d".format(it)}.000",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = MaterialTheme.colorScheme.error,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
            Text(text = product.price, style = MaterialTheme.typography.bodyMedium)

            Spacer(modifier = Modifier.height(16.dp))


            Button(
                onClick = onAffiliateClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp),
                contentPadding = PaddingValues(horizontal = 8.dp)
            ) {
                Text(
                    text = "Pengajuan Afiliasi",
                    maxLines = 1,
                    softWrap = false,
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontWeight = FontWeight.Medium
                    )
                )
            }
        }
    }
}
