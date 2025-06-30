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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun BottomNavBar(){
    val currentRoute = ""

    val items = listOf(
        BottomNavItem(
            title = "Home",
            icon = Icons.Default.Home,
            route = "Home"
        ),
        BottomNavItem(
            title = "Payment",
            icon = Icons.Default.ShoppingCart,
            route = "Payment"
        ),
        BottomNavItem(
            title = "Reviews",
            icon = Icons.Default.Star,
            route = "Reviews"
        ),
        BottomNavItem(
            title = "My Account",
            icon = Icons.Default.AccountCircle,
            route = "Account"
        )
    )
    NavigationBar(
        modifier = Modifier.height(82.dp),
        containerColor = Color(0xFFA5D6A7),
        tonalElevation = 8.dp
    ) {
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
                onClick = { /*TODO*/ })
        }
    }
}





data class BottomNavItem(
    val title: String,
    val icon: ImageVector,
    val route: String)
