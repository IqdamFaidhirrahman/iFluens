package com.example.kelassaya

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.*

import com.example.kelassaya.components.BottomNavigationBar
import com.example.kelassaya.ui.kelas.*
import com.example.kelassaya.ui.pembayaran.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) },
        floatingActionButton = {
            if (currentRoute == "kelas") {
                FloatingActionButton(
                    onClick = { navController.navigate("tambah_kelas") }
                ) {
                    Icon(Icons.Default.Add, contentDescription = "Tambah Kelas")
                }
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            NavigationGraph(navController)
        }
    }
}

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "kelas"
    ) {
        composable("kelas") { KelasScreen(navController) }
        composable("detail_kelas") { DetailKelasScreen(navController) }
        composable("materi") { MateriScreen(navController) }
        composable("feedback") { FeedbackScreen(navController) }
        composable("tambah_kelas") { TambahKelasScreen(navController) }
        composable("pembayaran") { PembayaranScreen(navController) }
        composable("qr_pembayaran") { QRPembayaranScreen(navController) }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp()
}
