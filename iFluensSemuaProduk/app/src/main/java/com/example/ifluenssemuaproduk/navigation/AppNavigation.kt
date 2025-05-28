package com.example.ifluenssemuaproduk.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ifluenssemuaproduk.ui.screens.HomeScreen
import com.example.ifluenssemuaproduk.ui.screens.ProductDetailScreen
import com.example.ifluenssemuaproduk.ui.screens.AffiliateLinkScreen

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object ProductDetail : Screen("product_detail/{productId}") {
        fun createRoute(productId: Int) = "product_detail/$productId"
    }
    object AffiliateLink : Screen("affiliate_link")
}

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(Screen.ProductDetail.route) {
            ProductDetailScreen(navController)
        }
        composable(Screen.AffiliateLink.route) {
            AffiliateLinkScreen(navController)
        }
    }
}
