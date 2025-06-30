package com.example.tutoringapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tutoringapp.navigation.Screens
import com.example.tutoringapp.screens.account.UserAccount
import com.example.tutoringapp.screens.account.UserLogin
import com.example.tutoringapp.screens.account.UserSignUp
import com.example.tutoringapp.screens.home.HomeScreen
import com.example.tutoringapp.screens.settings.SettingsScreen
import com.example.tutoringapp.ui.theme.TutoringAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            // navigation
            val navController = rememberNavController()
            // nav host for nav between screens
            NavHost(
                navController = navController,
                startDestination = "home"
            ) {
                //each screen is a composable function
                composable(Screens.Home.route) {
                    HomeScreen(navController = navController,
                        onAccountClick = { navController.navigate(Screens.Account.route) },
                        onSettingsClick = { navController.navigate(Screens.Settings.route) })
                }
                composable(Screens.Account.route) {
                    UserAccount(navController = navController, onSignOut = {})
                }
                composable(Screens.Login.route) {
                    UserLogin(
                        onNavigateToSignUp = { navController.navigate(Screens.SignUp.route) },
                        onLoginSuccess = { navController.navigate(Screens.Home.route) }
                    )
                }
                composable(Screens.SignUp.route) {
                    UserSignUp(
                        onNavigateToLogin = { navController.navigate(Screens.Login.route)},
                        onSignUpSuccess = { navController.navigate(Screens.Home.route)}
                    )
                }
                composable(Screens.Settings.route) {
                    SettingsScreen(navController = navController)
                }
            }
        }
    }
}
