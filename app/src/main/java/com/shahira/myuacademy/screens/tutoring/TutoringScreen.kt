package com.shahira.myuacademy.screens.tutoring

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.shahira.myuacademy.navigation.Screens


@Composable
fun TutoringScreen(navController: NavController) {
    var showCard by remember { mutableStateOf(false) }
    var showCard2 by remember { mutableStateOf(false) }
    var showCard3 by remember { mutableStateOf(false) }

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
        Spacer(modifier = Modifier.height(25.dp))

        Column(modifier = Modifier.padding(16.dp)) {
            Card(colors = CardDefaults.cardColors(containerColor = Color(0xFFA5D6A7)))
            {
                Row {
                    Text(
                        text = "1 Hour",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(30.dp)
                    )
                    Spacer(modifier = Modifier.padding(20.dp))
                    TextButton(
                        onClick = { navController.navigate(Screens.Payment.route) },
                        modifier = Modifier.align(Alignment.CenterVertically)
                    ) {
                        Text(
                            text = "Book Now",
                            color = Color.Blue,
                            fontWeight = FontWeight.Bold,
                            textDecoration = TextDecoration.Underline
                        )
                    }
                    Spacer(modifier = Modifier.padding(18.dp))
                    TextButton(
                        onClick = { showCard = true },
                        modifier = Modifier.align(Alignment.CenterVertically)
                    ) {
                        Text(
                            text = "Details",
                            color = Color.Blue,
                            textDecoration = TextDecoration.Underline
                        )
                    }
                    Spacer(modifier = Modifier.padding(16.dp))
                }
            }

            Spacer(modifier = Modifier.padding(16.dp))

            Card(colors = CardDefaults.cardColors(containerColor = Color(0xFFA5D6A7))) {
                Row {
                    Text(
                        text = "5 Hours",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(30.dp)
                    )
                    Spacer(modifier = Modifier.padding(16.dp))
                    TextButton(
                        onClick = { navController.navigate(Screens.Payment.route) },
                        modifier = Modifier.align(Alignment.CenterVertically)
                    ) {
                        Text(
                            text = "Book Now",
                            color = Color.Blue,
                            fontWeight = FontWeight.Bold,
                            textDecoration = TextDecoration.Underline
                        )
                    }
                    Spacer(modifier = Modifier.padding(18.dp))
                    TextButton(
                        onClick = { showCard2 = true },
                        modifier = Modifier.align(Alignment.CenterVertically)
                    ) {
                        Text(
                            text = "Details",
                            color = Color.Blue,
                            textDecoration = TextDecoration.Underline
                        )
                    }
                    Spacer(modifier = Modifier.padding(16.dp))
                }
            }

            Spacer(modifier = Modifier.padding(16.dp))

            Card(colors = CardDefaults.cardColors(containerColor = Color(0xFFA5D6A7))) {
                Row {
                    Text(
                        text = "10 Hours",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(30.dp)
                    )
                    Spacer(modifier = Modifier.padding(11.dp))
                    TextButton(
                        onClick = { navController.navigate(Screens.Payment.route) },
                        modifier = Modifier.align(Alignment.CenterVertically)
                    ) {
                        Text(
                            text = "Book Now",
                            color = Color.Blue,
                            fontWeight = FontWeight.Bold,
                            textDecoration = TextDecoration.Underline
                        )
                    }
                    Spacer(modifier = Modifier.padding(18.dp))
                    TextButton(
                        onClick = { showCard3 = true },
                        modifier = Modifier.align(Alignment.CenterVertically)
                    ) {
                        Text(
                            text = "Details",
                            color = Color.Blue,
                            textDecoration = TextDecoration.Underline
                        )
                    }
                    Spacer(modifier = Modifier.padding(16.dp))
                }
            }
        }
    }
    if (showCard) {
        Dialog(
            onDismissRequest = { showCard = false }
        ) {
            // Surface so the dialog content can fill the screen
            Surface(
                modifier = Modifier
                    .width(300.dp)           // or .fillMaxWidth(0.9f)
                    .wrapContentHeight()     // only as tall as your card needs
                    .padding(16.dp),
                tonalElevation = 8.dp,
                shape = RoundedCornerShape(12.dp)
            ) {
                // but tapping outside or pressing register closes registration form
                OneHourCard(navController = navController)
            }
        }
    }
    if (showCard2) {
        Dialog(
            onDismissRequest = { showCard2 = false }
        ) {
            // Surface so the dialog content can fill the screen
            Surface(
                modifier = Modifier
                    .width(300.dp)           // or .fillMaxWidth(0.9f)
                    .wrapContentHeight()     // only as tall as your card needs
                    .padding(16.dp),
                tonalElevation = 8.dp,
                shape = RoundedCornerShape(12.dp)
            ) {
                // but tapping outside or pressing register closes registration form
                FiveHourCard(navController = navController)
            }
        }
    }
    if (showCard3) {
        Dialog(
            onDismissRequest = { showCard3 = false }
        ) {
            // Surface so the dialog content can fill the screen
            Surface(
                modifier = Modifier
                    .width(300.dp)           // or .fillMaxWidth(0.9f)
                    .wrapContentHeight()     // only as tall as your card needs
                    .padding(16.dp),
                tonalElevation = 8.dp,
                shape = RoundedCornerShape(12.dp)
            ) {
                // but tapping outside or pressing register closes registration form
                TenHourCard(navController = navController)
            }
        }
    }
}