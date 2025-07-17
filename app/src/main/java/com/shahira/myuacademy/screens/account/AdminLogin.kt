package com.shahira.myuacademy.screens.account

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.shahira.myuacademy.viewmodels.AuthViewModel

@Composable
fun AdminLogin(
              onLoginSuccess: () -> Unit,
              authViewModel: AuthViewModel = hiltViewModel()
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var adminKey by remember { mutableStateOf("") }

    // auth state
    val authState by authViewModel.authState.collectAsState()

    LaunchedEffect(authState) {
        if (authState is AuthViewModel.AuthState.Success) {
            onLoginSuccess()
        }
    }
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Login Screen",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 32.dp)
        )
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            )
        )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("password") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            )
        )
        OutlinedTextField(
            value = adminKey,
            onValueChange = { adminKey = it },
            label = { Text("Admin Key") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,    // numeric input
                imeAction     = ImeAction.Done
            )
        )
        Spacer(Modifier.height(16.dp))

        Button(
            onClick = {
                // parse the key, default to 0 if empty or invalid
                val keyInt = adminKey.toIntOrNull() ?: 0
                authViewModel.adminLogin(email, password, keyInt) },
            modifier = Modifier.fillMaxWidth().height(50.dp)
        ) {
            // if login is not loading
            Text("Login")
        }
    }
}