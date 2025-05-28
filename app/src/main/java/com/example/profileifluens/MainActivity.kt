package com.example.profileifluens

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.*
import com.example.profileifluens.ViewModel.AccountViewModel
import com.example.profileifluens.ui.ProfileScreen
import com.example.profileifluens.ui.AccountDetailScreen
import com.example.profileifluens.ui.EditProfileScreen
import com.example.profileifluens.ui.NotificationScreen
import com.example.profileifluens.ui.PasswordSecurityScreen

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val vm: AccountViewModel = viewModel()
            NavHost(navController = navController, startDestination = "profile") {

                composable("profile") {
                    ProfileScreen(navController)
                }

                composable("account_detail") {
                    AccountDetailScreen(navController, vm)
                }

                composable("notification") {
                    NotificationScreen(navController)
                }

                composable("edit_profile") {
                    EditProfileScreen(navController, vm)
                }

                composable("password") {
                    PasswordSecurityScreen(navController)
                }
            }
        }
    }
}