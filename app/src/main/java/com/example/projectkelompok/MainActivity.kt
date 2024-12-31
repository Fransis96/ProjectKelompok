package com.example.projectkelompok

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.projectkelompok.ui.theme.ProjectKelompokTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProjectKelompokTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ProjectApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProjectApp() {
    // Create a NavController
    val navController = rememberNavController()

    Scaffold(
        content = { paddingValues ->
            // Setup NavHost to manage navigation between screens
            NavHost(
                navController = navController,
                startDestination = "home",  // Starting screen
                modifier = Modifier.padding(paddingValues)
            ) {
                // Define composables for each screen
                composable("home") {
                    HomeScreen(navController = navController)  // HomeScreen navigation
                }
                composable("about") {
                    AboutScreen(navController = navController)  // AboutScreen when navigated to AboutApp
                }
                composable("ourteam") {
                    OurTeamScreen(navController = navController)  // OurTeamScreen for team information
                }
            }
        }
    )
}