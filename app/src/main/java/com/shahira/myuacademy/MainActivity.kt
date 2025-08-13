package com.shahira.myuacademy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.shahira.myuacademy.navigation.Screens
import com.shahira.myuacademy.navigation.WebsiteScreen
import com.shahira.myuacademy.repositories.CourseRepository
import com.shahira.myuacademy.screens.account.AdminAccount
import com.shahira.myuacademy.screens.account.AdminLogin
import com.shahira.myuacademy.screens.account.UserAccount
import com.shahira.myuacademy.screens.account.UserLogin
import com.shahira.myuacademy.screens.account.UserSignUp
import com.shahira.myuacademy.screens.calculator.CalculatorScreen
import com.shahira.myuacademy.screens.crashcourses.CourseDetailsScreen
import com.shahira.myuacademy.screens.crashcourses.CrashCoursesScreen
import com.shahira.myuacademy.screens.hiring.HiringFabScreen
import com.shahira.myuacademy.screens.home.BottomNavBar
import com.shahira.myuacademy.screens.home.ContactUs
import com.shahira.myuacademy.screens.home.HomeScreen
import com.shahira.myuacademy.screens.home.MyTopAppBar
import com.shahira.myuacademy.screens.payment.PaymentScreen
import com.shahira.myuacademy.screens.reviews.ReviewsScreen
import com.shahira.myuacademy.screens.settings.SettingsScreen
import com.shahira.myuacademy.screens.tutoring.OneHourCard
import com.shahira.myuacademy.screens.tutoring.TutoringScreen
import com.shahira.myuacademy.viewmodels.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val navController = rememberNavController()

            var showForm by remember { mutableStateOf(false) }
            var name by remember { mutableStateOf("") }
            var email by remember { mutableStateOf("") }
            var phone by remember { mutableStateOf(0) }
            var message by remember { mutableStateOf("") }

            // auth view model
            val authViewModel : AuthViewModel = hiltViewModel()

            // properly observe the state
            val isLoggedIn by remember{
                derivedStateOf {
                    authViewModel.isLoggedIn
                }
            }

            //val web="www.myuacademy.net/tutoring-calculus-geometry-algebra"

            Scaffold(
            // all 3 always on screen
                topBar = {
                    MyTopAppBar(
                        onSettingsClick = { navController.navigate(Screens.Settings.route) },
                        onCrashCoursesClick = { navController.navigate(Screens.CrashCourses.route) },
                        onTutoringClick = { navController.navigate(Screens.Tutoring.route) },
                        onHiringClick = { navController.navigate(Screens.Hiring.route) })
                },

                bottomBar = { BottomNavBar(navController) },

                floatingActionButton = { ContactUs() }
            )

            { innerPadding ->
                Box(
                    Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = Screens.Home.route,
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
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
                                onLoginSuccess = {
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
                            ReviewsScreen(
                                navController = navController,
                                reviewViewModel = hiltViewModel(),
                                innerPadding = innerPadding
                            )
                        }


                        composable(Screens.Calculator.route) {
                            CalculatorScreen(navController = navController)
                        }
//                        composable(Screens.Payment.route) {
//                            PaymentScreen(navController = navController)
//                        }
                        composable(Screens.CrashCourses.route) {
                            CrashCoursesScreen(
                               // courseList = CourseRepository.allCourses,
                                navController = navController
                            )
                        }
                        composable(
                            route = Screens.CourseDetails.route + "/{index}",
                            arguments = listOf(navArgument("index") {
                                type = NavType.IntType
                            })
                        ) { backStackEntry ->
                            val idx = backStackEntry.arguments!!.getInt("index")
                           val course = CourseRepository.allCourses[idx]
                            CourseDetailsScreen(
                                course = course,
                                //onBack = { navController.popBackStack() }
                            )
                        }

                        composable(Screens.Tutoring.route) {
                            TutoringScreen(navController = navController)
                        }
                        composable(Screens.Hiring.route) {
                            HiringFabScreen()
                        }

                        composable(Screens.OneHour.route) {
                            OneHourCard(navController = navController)
                        }

                        composable(Screens.Website.route) {
                            WebsiteScreen()
                        }
                    }
                    if (showForm) {
                        Dialog(
                            onDismissRequest = { showForm = false }
                        ) {
                            // Surface so the dialog content can fill the screen
                            Surface(
                                modifier = Modifier
                                    .height(500.dp)
                                    .padding(16.dp)
                                    .align(Alignment.Center)
                            ) {

                                // 2) Properly pass the hoisted state into ContactUs
//                                AnimatedVisibility(visible = showForm) {
//                                    ContactUs(
//                                        modifier = Modifier.padding(top = 16.dp),
//                                        name = name,                           // ← use your state here
//                                        onNameChange = { name = it },
//                                        email = email,
//                                        onEmailChange = { email = it },
//                                        phone = phone,
//                                        onPhoneChange = { phone = it },
//                                        message = message,
//                                        onMessageChange = { message = it },
//                                        onSend = {
//                                            /** add logic here */
//
//                                            showForm = false
//                                        })
//                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
