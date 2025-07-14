package com.example.tutoringapp.screens.home

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController,
               onAccountClick: () -> Unit,
               onSettingsClick: () -> Unit) {
    // 1) Hoist all your state here
    var showForm by remember { mutableStateOf(false) }               // hidden by default :contentReference[oaicite:0]{index=0}
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf(0) }
    var message by remember { mutableStateOf("") }

    Scaffold(

        floatingActionButton = {
            FloatingActionButton(
                onClick = { showForm = !showForm },
                containerColor = Color(0xFFA5D6A7)
            ) {
                    Text(
                        "Contact Us",
                        modifier = Modifier.padding(10.dp),
                        fontWeight = FontWeight.Bold
                    )
                }
            },
        floatingActionButtonPosition = FabPosition.End
    ) { innerPadding ->
        Box(
            Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.TopCenter
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Card(colors = CardDefaults.cardColors(containerColor = Color(0xFFA5D6A7)))
                {
                    PhotoGallery(
                        modifier = Modifier.height(250.dp).border(20.dp, Color(0xFFA5D6A7), RoundedCornerShape(3) ),   // constrain its size
                        autoScroll = true,
                        slideIntervalMs = 5000L
                    )
                }

                Spacer(modifier = Modifier.padding(15.dp))

                Card(colors = CardDefaults.cardColors(containerColor = Color(0xFFA5D6A7)))
                {
                    Text(
                        text = "One-on-one tutoring that can take place in your home, online, or in person at our tutoring center with an affordable rates which starts from \$30 per hour.  Upon request, for new students, we offer a free 35-minute session before submitting any payment information. Please don't hesitate to reach out us now If you have questions or are interested in our services.",
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp,
                        modifier = Modifier.padding(30.dp)
                    )

                    Text(
                        text = "Note: Before purchasing, please contact us for the availability and payment options, we accept Zelle and Venmo as well.",
                        fontSize = 13.sp,
                        color = Color.Red,
                        modifier = Modifier.padding(30.dp)
                    )

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
                        AnimatedVisibility(visible = showForm) {
                            ContactUs(
                                modifier = Modifier.padding(top = 16.dp),
                                name = name,                           // ← use your state here
                                onNameChange = { name = it },
                                email = email,
                                onEmailChange = { email = it },
                                phone = phone,
                                onPhoneChange = { phone = it },
                                message = message,
                                onMessageChange = { message = it },
                                onSend = {
                                    /** add logic here */

                                    showForm = false
                                })
                        }
                    }
                }
            }
        }
    }
}