package com.example.tutoringapp.screens.home

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.tutoringapp.navigation.Screens

@Composable
fun BottomNavBar( navController: NavController){
    val currentRoute = ""

    val items = listOf(
        BottomNavItem(
            title = "Home",
            icon = Icons.Default.Home,
            route = Screens.Home.route
        ),
        BottomNavItem(
            title = "Payment",
            icon = Icons.Default.ShoppingCart,
            route = Screens.Payment.route
        ),
        BottomNavItem(
            title = "Reviews",
            icon = Icons.Default.Star,
            route = Screens.Reviews.route
        ),
        BottomNavItem(
            title = "My Account",
            icon = Icons.Default.AccountCircle,
            route = Screens.Account.route
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
                onClick = {navController.navigate(item.route){
                    popUpTo(navController.graph.startDestinationId)
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
