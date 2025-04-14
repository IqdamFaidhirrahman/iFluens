package com.example.ifluenssemuaproduk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.ifluenssemuaproduk.navigation.AppNavigation
import com.example.ifluenssemuaproduk.ui.theme.IFluensSemuaProdukTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IFluensSemuaProdukTheme {
                MainApp()
            }
        }
    }
}

@Composable
fun MainApp() {
    val navController = rememberNavController()
    Surface(color = MaterialTheme.colorScheme.background) {
        AppNavigation(navController = navController)
    }
}