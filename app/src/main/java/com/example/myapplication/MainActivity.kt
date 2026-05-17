package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.screens.LoginScreen
import com.example.myapplication.screens.RegisterScreen
import com.example.myapplication.screens.WelcomeScreen
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                val navController = rememberNavController()

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "welcome",
                        modifier = Modifier.padding(innerPadding),
                    ) {
                        composable("welcome") {
                            WelcomeScreen(
                                onLoginClick = { navController.navigate("login") },
                                onRegisterClick = { navController.navigate("register") },
                            )
                        }
                        composable("login") {
                            LoginScreen(
                                onCreateAccountClick = { navController.navigate("register") },
                            )
                        }
                        composable("register") {
                            RegisterScreen(
                                onAlreadyHaveAccountClick = { navController.navigate("login") },
                            )
                        }
                    }
                }
            }
        }
    }
}
