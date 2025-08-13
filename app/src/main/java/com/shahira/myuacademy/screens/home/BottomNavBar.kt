package com.shahira.myuacademy.screens.home

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.shahira.myuacademy.R
import com.shahira.myuacademy.navigation.Screens
import com.shahira.myuacademy.viewmodels.AuthViewModel

@Composable
fun BottomNavBar( navController: NavController,
                  authViewModel: AuthViewModel = hiltViewModel())
{
    val isAdmin by authViewModel.isAdminLogin.collectAsState()
    val isLoggedIn by remember { derivedStateOf { authViewModel.isLoggedIn } }

    // pick the right route
    val accountRoute = if (isAdmin) {
        Screens.AdminAccount.route
    } else {
        Screens.UserAccount.route
    }

    val items = listOf(
        BottomNavItem(
            title = "Home",
            icon = Icons.Default.Home,
            route = Screens.Home.route
        ),
//        BottomNavItem(
//            title = "Payment",
//            icon = Icons.Default.ShoppingCart,
//            route = Screens.Payment.route
//        ),
        BottomNavItem(
            title = "Calculator",
//            icon = ImageVector.vectorResource(id=R.drawable.calculator),
            icon = Icons.Default.AddCircle,
            route = Screens.Calculator.route
        ),
        BottomNavItem(
            title = "Reviews",
            icon = Icons.Default.Star,
            route = Screens.Reviews.route
        ),
        BottomNavItem(
            title = "My Account",
            icon = Icons.Default.AccountCircle,
            route = accountRoute
        )
    )
    NavigationBar(
        modifier = Modifier.height(82.dp),
        containerColor = Color(0xFFA5D6A7),
        tonalElevation = 8.dp
    ) {
        //converting the current nav backstack entry into a state
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        //getting the route of the current destination
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach{item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title,
                        modifier = Modifier.size(20.dp)
                    )
                },
                label = {Text(item.title)},
                selected = currentRoute == item.route,
                onClick = {
                    val target = if (!authViewModel.isLoggedIn && item.route == accountRoute)
                        Screens.Login.route
                    else
                        item.route

                    navController.navigate(target) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                    }
                },
                alwaysShowLabel = true
            )
        }
    }
}

data class BottomNavItem(
    val title: String,
    val icon: ImageVector,
    val route: String)
