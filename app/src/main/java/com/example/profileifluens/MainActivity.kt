package com.example.profileifluens

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.compose.*
import com.example.profileifluens.ui.ProfileScreen
import com.example.profileifluens.ui.AccountDetailScreen
import com.example.profileifluens.ui.NotificationScreen

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "profile") {

                composable("profile") {
                    ProfileScreen(navController)
                }

                composable("account_detail") {
                    AccountDetailScreen(navController)
                }

                composable("notification") {
                    NotificationScreen(navController)
                }

            }
        }
    }
}