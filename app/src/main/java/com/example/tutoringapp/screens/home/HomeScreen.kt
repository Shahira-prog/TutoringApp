package com.example.tutoringapp.screens.home

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
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
import androidx.navigation.NavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController,
               onAccountClick: () -> Unit,
               onSettingsClick: () -> Unit) {
    // 1) Hoist all your state here
    var showForm by remember { mutableStateOf(false) }               // hidden by default :contentReference[oaicite:0]{index=0}
    var name     by remember { mutableStateOf("") }
    var email    by remember { mutableStateOf("") }
    var phone    by remember { mutableStateOf(0) }
    var message  by remember { mutableStateOf("") }

    Scaffold(
        topBar    = { MyTopAppBar(onSettingsClick)},
        bottomBar = { BottomNavBar() },
        floatingActionButton = {
            FloatingActionButton(onClick = { showForm = !showForm }, containerColor = Color(0xFFA5D6A7)) {
                if (showForm){
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close"
                    )
                } else {
                    Text(
                        "Contact Us",
                        modifier = Modifier.padding(10.dp),
                        fontWeight = FontWeight.Bold
                    )
                }
//                Icon(
//                    imageVector = if (showForm) Icons.Default.Close
//                    else Icons.Default.Email,
//                    contentDescription = "Contact Us"
//                )
            }
        },
        floatingActionButtonPosition = FabPosition.End
    ) { innerPadding ->
        Box(
            Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            Text("demo")

            // 2) Properly pass the hoisted state into ContactUs
            AnimatedVisibility(visible = showForm) {
                ContactUs(
                    modifier        = Modifier.padding(top = 16.dp),
                    name            = name,                           // ← use your state here
                    onNameChange    = { name = it },
                    email           = email,
                    onEmailChange   = { email = it },
                    phone           = phone,
                    onPhoneChange   = { phone = it },
                    message         = message,
                    onMessageChange = { message = it },
                    onSend          = {
                        /** add logic here */
                        showForm = false
                    }
                )
            }
        }
    }
}