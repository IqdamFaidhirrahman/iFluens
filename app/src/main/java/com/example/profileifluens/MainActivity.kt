package com.example.profileifluens

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.compose.*
import com.example.profileifluens.ui.ProfileScreen
import com.example.profileifluens.ui.AccountDetailScreen
import com.example.profileifluens.ui.NotificationScreen
import com.example.profileifluens.ui.HomeScreen

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "Homepage") {

                composable("profile") {
                    ProfileScreen(navController)
                }

                composable("account_detail") {
                    AccountDetailScreen(navController)
                }

                composable("notification") {
                    NotificationScreen(navController)
                }
                composable("Homepage"){
                    HomeScreen(navController)
                }

            }
        }
    }
}