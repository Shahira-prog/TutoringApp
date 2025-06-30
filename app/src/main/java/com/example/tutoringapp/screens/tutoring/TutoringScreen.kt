package com.example.tutoringapp.screens.tutoring

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun TutoringScreen(navController: NavController) {
    Column {

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "One-on-one tutoring that can take place in your home, online, or in person at our tutoring center with an affordable rates which starts from $30 per hour. Upon request, for new students, we offer a free 35-minute session before submitting any payment information. Please don't hesitate to reach out us now If you have questions or are interested in our services.",
            fontSize = 17.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        )

        Spacer(modifier = Modifier.height(11.dp))

        Text(
            text = "Note: Before purchasing, please contact us for the availability and payment options, we accept Zelle and Venmo as well.",
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = Color.Red,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(75.dp))

        Row(modifier = Modifier.padding(16.dp)) {
            Card {
                Text(text = "card 1")
            }

            Spacer(modifier = Modifier.weight(1f))

            Card {
                Text(text = "card 2")
            }

            Spacer(modifier = Modifier.weight(1f))

            Card {
                Text(text = "card 3")
            }
        }
    }
}