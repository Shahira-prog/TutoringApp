package com.shahira.myuacademy.screens.tutoring

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.shahira.myuacademy.navigation.Screens

@Composable
fun FiveHourCard(navController: NavController)
{
    Card(modifier = Modifier.width(280.dp)
        .background(Color(0xFFA5D6A7))
        .padding(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFA5D6A7)))
    {
        Column{
            Text(text = "5 Hours",
                style = MaterialTheme.typography.titleLarge.copy(
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontWeight = FontWeight.Bold,
                    textDecoration = TextDecoration.Underline)
            )
            Spacer(modifier = Modifier.height(40.dp))
            Text(
                text = "$225 for Five Hours",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(40.dp))
            Text(
                text = "1 on 1 Math Tutoring, student will be provided step by step guidance. Valid for 6 months.",
                style = MaterialTheme.typography.headlineSmall
            )
            Spacer(modifier = Modifier.height(22.dp))

//            TextButton(onClick = { navController.navigate(Screens.Payment.route)},
//                modifier = Modifier.align(Alignment.CenterHorizontally)){
//                Text(text = "Book Now",
//                    fontSize = 20.sp,
//                    color = Color.Blue,
//                    fontWeight = FontWeight.Bold,
//                    textDecoration = TextDecoration.Underline)
//            }
            Box(modifier = Modifier.fillMaxSize()) {
                Text(
                    modifier = Modifier.align(Alignment.BottomStart),
                    text = "Cancel/reschedule 12 hours in advance notification required. All prepaid purchasing are nonrefundable, valid for 6 months.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Red
                )
            }

        }
    }
}