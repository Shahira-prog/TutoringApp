package com.shahira.myuacademy.navigation

sealed class Screens(val route: String) {
    object Home : Screens("home")
    object Settings : Screens("settings")
    object UserAccount : Screens("useraccount")
    object AdminAccount : Screens("adminaccount")
   object Login : Screens("login")
   object SignUp : Screens("signup")
    object Reviews : Screens("reviews")
    object Payment : Screens("payment")
    object Tutoring : Screens("tutoring")
    object CrashCourses : Screens("crashcourses")
    object Hiring : Screens("hiring")
    object AdminLogin : Screens("adminlogin")
    object Calculator : Screens("calculator")


}
