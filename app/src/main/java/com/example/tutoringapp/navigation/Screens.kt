package com.example.tutoringapp.navigation

sealed class Screens(val route: String) {
    object Home : Screens("home")
    object Account : Screens("account")
    object Settings : Screens("settings")
   object Login : Screens("login")
   object SignUp : Screens("signup")
    object Reviews : Screens("reviews")
    object Payment : Screens("payment")
    object Tutoring : Screens("tutoring")
    object CrashCourses : Screens("crashcourses")
    object Hiring : Screens("hiring")
}
