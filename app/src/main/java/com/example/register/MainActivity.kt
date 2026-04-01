package com.example.register

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.register.ui.screens.LoginScreen
import com.example.register.ui.screens.MainScreen
import com.example.register.ui.screens.RegisterScreen
import com.example.register.ui.theme.RegisterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RegisterTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Memasukkan innerPadding ke dalam AppNavigation
                    AppNavigation(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "register", // Aplikasi dimulai dari halaman Register
        modifier = modifier
    ) {
        composable("login") {
            LoginScreen(
                onLoginSuccess = {
                    // Berpindah ke MainScreen setelah login berhasil
                    navController.navigate("main") {
                        popUpTo("login") { inclusive = true }
                    }
                },
                onNavigateToRegister = {
                    navController.navigate("register")
                }
            )
        }
        composable("register") {
            RegisterScreen(
                onRegisterSuccess = {
                    // Setelah register, arahkan ke login
                    navController.navigate("login")
                },
                onNavigateToLogin = {
                    navController.navigate("login")
                }
            )
        }
        composable("main") {
            // Halaman Utama setelah login
            MainScreen()
        }
    }
}
