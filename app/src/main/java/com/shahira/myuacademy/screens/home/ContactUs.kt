package com.shahira.myuacademy.screens.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactUs(modifier: Modifier = Modifier,
              name: String = "",
              onNameChange: (String) -> Unit = {},
              email: String = "",
              onEmailChange: (String) -> Unit = {},
              phone: Int = 0,
              onPhoneChange: (Int) -> Unit = {},
              message: String = "",
              onMessageChange: (String) -> Unit = {},
              onSend: () -> Unit = {}
)
{
    Card(modifier = Modifier.width(280.dp)
        .border(2.dp, Color.Black, shape = RectangleShape)
        .background(Color.White)
        .padding(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)){
        Column {
            Text(
                text = "Contact Us",
                style = MaterialTheme.typography.headlineMedium.copy(
                    color = Color(0xFF125E12),
                    fontWeight = FontWeight.Bold)
                )

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value            = name,
                onValueChange    = onNameChange,
                label            = { Text("Name") },
                singleLine       = true,
                modifier         = Modifier.fillMaxWidth(),
                colors           = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color.White
                )
            )

            Spacer(Modifier.height(8.dp))

            OutlinedTextField(
                value            = email,
                onValueChange    = onEmailChange,
                label            = { Text("Email") },
                singleLine       = true,
                modifier         = Modifier.fillMaxWidth(),
                keyboardOptions  = KeyboardOptions(keyboardType = KeyboardType.Email),
                colors           = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color.White
                )
            )

            Spacer(Modifier.height(8.dp))

            OutlinedTextField(
                value            = phone.toString(),
                onValueChange    = { onPhoneChange(it.toIntOrNull() ?: 0) },
                label            = { Text("Phone") },
                singleLine       = false,
                modifier         = Modifier.fillMaxWidth(),
                keyboardOptions  = KeyboardOptions(keyboardType = KeyboardType.Phone),
                colors           = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color.White
                )
            )

            Spacer(Modifier.height(8.dp))

            OutlinedTextField(
                value            = message,
                onValueChange    = onMessageChange,
                label            = { Text("Message") },
                singleLine       = false,
                modifier         = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                colors           = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color.White
                )
            )

            Spacer(Modifier.height(12.dp))

            Button(
                onClick  = onSend,
                modifier = Modifier.align(Alignment.End),
                colors   = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF125E12),
                    contentColor   = Color.White
                )
            ) {
                Text("Send")
            }

        }
    }
}
@Composable
fun ContactUsFabScreen(
    name: String = "",
    onNameChange: (String) -> Unit = {},
    email: String = "",
    onEmailChange: (String) -> Unit = {},
    phone: Int = 0,
    onPhoneChange: (Int) -> Unit = {},
    message: String = "",
    onMessageChange: (String) -> Unit = {},
    onSend: () -> Unit = {}
) {
    var showForm by remember { mutableStateOf(false) }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showForm = !showForm },
                containerColor = Color(0xFFA5D6A7)
            ) {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "Contact Us"
                )
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.TopCenter
        ) {
            AnimatedVisibility(visible = showForm) {
                ContactUs(
                    modifier = Modifier.padding(top = 16.dp),
                    name = name,
                    onNameChange = onNameChange,
                    email = email,
                    onEmailChange = onEmailChange,
                    phone = phone,
                    onPhoneChange = onPhoneChange,
                    message = message,
                    onMessageChange = onMessageChange,
                    onSend = {
                        onSend()
                        showForm = false
                    }
                )
            }
        }
    }
}
