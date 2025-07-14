package com.example.tutoringapp.screens.hiring

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HiringScreen(
    modifier: Modifier = Modifier,
    name: String = "",
    onNameChange: (String) -> Unit = {},
    email: String = "",
    onEmailChange: (String) -> Unit = {},
    phone: String = "",
    onPhoneChange: (String) -> Unit = {},
    position: String = "",
    onPositionChange: (String) -> Unit = {},
    startingDate: String = "",
    onStartingDateChange: (String) -> Unit = {},
    onSend: () -> Unit = {},
    onAttachment: () -> Unit = {}
) {
    Card(
        modifier = modifier
            .requiredSize(width = 380.dp, height = 650.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFFA5D6A7))
            .padding(10.dp),
        //elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFA5D6A7)),
    ) {
        Text(
            text = "Apply Now",
            color = Color.Black,
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(15.dp))

        Column {

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = name,
                onValueChange = onNameChange,
                label = { Text("Name") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color.White
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = email,
                onValueChange = onEmailChange,
                label = { Text("Email") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color.White
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = phone,
                onValueChange = onPhoneChange,
                label = { Text("Phone") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color.White
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = position,
                onValueChange = onPositionChange,
                label = { Text("Position") },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color.White
                )
            )

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = startingDate,
                onValueChange = onStartingDateChange,
                label = { Text("Starting Date") },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color.White
                )
            )

            Spacer(modifier = Modifier.height(12.dp))
            Row {

                Button(
                    onClick = onAttachment,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF125E12),
                        contentColor = Color.White
                    )
                ) {
                    Text("Attach Resume")
                }

                Spacer(modifier = Modifier.weight(1f))

                Button(
                    onClick = onSend,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF125E12),
                        contentColor = Color.White
                    )
                ) {
                    Text("Submit")
                }
            }
        }
    }
}

@Composable
fun HiringFabScreen(
    name: String = "",
    onNameChange: (String) -> Unit = {},
    email: String = "",
    onEmailChange: (String) -> Unit = {},
    phone: String = "",
    onPhoneChange: (String) -> Unit = {},
    position: String = "",
    onPositionChange: (String) -> Unit = {},
    startingDate: String = "",
    onStartingDateChange: (String) -> Unit = {},
    onSend: () -> Unit = {},
    onAttachment: () -> Unit = {}
) {
    var showForm by remember { mutableStateOf(true) }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        AnimatedVisibility(visible = showForm) {
            HiringScreen(
                modifier = Modifier.padding(top = 16.dp),
                name = name,
                onNameChange = onNameChange,
                email = email,
                onEmailChange = onEmailChange,
                phone = phone,
                onPhoneChange = onPhoneChange,
                position = position,
                onPositionChange = onPositionChange,
                startingDate = startingDate,
                onStartingDateChange = onStartingDateChange,
                onSend = { onSend() },
                onAttachment = { onAttachment() }
            )
        }
    }
}