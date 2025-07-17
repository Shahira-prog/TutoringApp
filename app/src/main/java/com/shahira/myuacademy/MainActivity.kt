package com.shahira.myuacademy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.shahira.myuacademy.navigation.Screens
import com.shahira.myuacademy.screens.account.AdminAccount
import com.shahira.myuacademy.screens.account.AdminLogin
import com.shahira.myuacademy.screens.account.UserAccount
import com.shahira.myuacademy.screens.account.UserLogin
import com.shahira.myuacademy.screens.account.UserSignUp
import com.shahira.myuacademy.screens.crashcourses.CrashCoursesScreen
import com.shahira.myuacademy.screens.hiring.HiringFabScreen
import com.shahira.myuacademy.screens.home.BottomNavBar
import com.shahira.myuacademy.screens.home.HomeScreen
import com.shahira.myuacademy.screens.home.MyTopAppBar
import com.shahira.myuacademy.screens.payment.PaymentScreen
import com.shahira.myuacademy.screens.reviews.ReviewsScreen
import com.shahira.myuacademy.screens.settings.SettingsScreen
import com.shahira.myuacademy.screens.tutoring.TutoringScreen
import com.shahira.myuacademy.viewmodels.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            // navigation
            val navController = rememberNavController()

            // auth view model
            val authViewModel : AuthViewModel = hiltViewModel()

            // properly observe the state
            val isLoggedIn by remember{
                derivedStateOf {
                    authViewModel.isLoggedIn
                }
            }

            Scaffold(
            // both always on screen
            topBar    = { MyTopAppBar(
                onSettingsClick = { navController.navigate(Screens.Settings.route) },
                onCrashCoursesClick = { navController.navigate(Screens.CrashCourses.route) },
                onTutoringClick = { navController.navigate(Screens.Tutoring.route) },
                onHiringClick = { navController.navigate(Screens.Hiring.route) }) },

            bottomBar = { BottomNavBar(navController) }
            ){ innerPadding ->
                NavHost(
                    navController    = navController,
                    startDestination = Screens.Home.route,
                    modifier         = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                ) {
                        //each screen is a composable function
                    composable(Screens.Home.route) {
                        val authViewModel: AuthViewModel = hiltViewModel()
                        val isAdmin by authViewModel
                            .isAdminLogin
                            .collectAsState(initial = false)

                        HomeScreen(
                            navController = navController,
                            onAccountClick = {
                                val dest = if (isAdmin)
                                    Screens.AdminAccount.route
                                else
                                    Screens.UserAccount.route

                                navController.navigate(dest) {
                                    popUpTo(Screens.Home.route) { inclusive = false }
                                }
                            },
                            onSettingsClick = { navController.navigate(Screens.Settings.route) }
                        )
                    }
                        composable(Screens.UserAccount.route) {
                            UserAccount(navController = navController, onSignOut = {
                                authViewModel.signOut()
                                navController.navigate(Screens.Login.route) {
                                    popUpTo(Screens.UserAccount.route) { inclusive = true }
                                }
                            })
                        }
                        composable(Screens.Login.route) {
                            UserLogin(
                                onNavigateToSignUp = { navController.navigate(Screens.SignUp.route) },
                                onNavigateToAdminLogin = { navController.navigate(Screens.AdminLogin.route) },
                                onLoginSuccess          = {
                                    navController.navigate(Screens.UserAccount.route) {
                                        popUpTo(Screens.Login.route) { inclusive = true }
                                    }
                                }
                            )
                        }
                        composable(Screens.SignUp.route) {
                            UserSignUp(
                                onNavigateToLogin = { navController.navigate(Screens.Login.route) },
                                onSignUpSuccess = { navController.navigate(Screens.Home.route) }
                            )
                        }
                    composable(Screens.AdminAccount.route) {
                        AdminAccount(navController = navController, onSignOut = {
                            authViewModel.signOut()
                            navController.navigate(Screens.Login.route) {
                                popUpTo(Screens.AdminAccount.route) { inclusive = true }
                            }
                        })
                    }

                        composable(Screens.AdminLogin.route) {
                            AdminLogin(
                                onLoginSuccess = {
                                    navController.navigate(Screens.AdminAccount.route) {
                                        popUpTo(Screens.AdminLogin.route) { inclusive = true }
                                    }
                                }
                            )
                        }

                        composable(Screens.Settings.route) {
                            SettingsScreen(navController = navController)
                        }
                        composable(Screens.Reviews.route) {
                            ReviewsScreen(navController = navController)
                        }
                        composable(Screens.Payment.route) {
                            PaymentScreen(navController = navController)
                        }
                        composable(Screens.CrashCourses.route) {
                            CrashCoursesScreen(navController = navController)
                        }
                        composable(Screens.Tutoring.route) {
                            TutoringScreen(navController = navController)
                        }
                        composable(Screens.Hiring.route) {
                            HiringFabScreen()
                        }
                    }
            }
        }
    }
}
