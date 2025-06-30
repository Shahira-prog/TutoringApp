package com.example.tutoringapp.screens.account

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
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun UserSignUp(onNavigateToLogin: () -> Unit,
               onSignUpSuccess: () -> Unit,)
{
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    // auth state
    val authState = true

    var passwordError by remember { mutableStateOf<String?>(null) }

    if (authState) {
        onSignUpSuccess()
    }
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Create Account",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 32.dp)
        )
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
            singleLine = true
        )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("password") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
            singleLine = true
        )
        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = { Text("confirm Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
            singleLine = true,
            isError = passwordError != null,
            supportingText =
            {
                passwordError?.let {
                    Text(
                        text = it,
                        color = MaterialTheme.colorScheme.error
                    )
                }
            }
        )
        Spacer(Modifier.height(16.dp))
        Button(
            onClick = {
                if (password != confirmPassword) {
                    passwordError = "Passwords do not match"
                } else if (password.length < 6) {
                    passwordError = "Password must be at least 6 characters"
                } else {
                    passwordError = null
                    // viewmodel call

                }
            },
            modifier = Modifier.fillMaxWidth().height(50.dp),
        ) {
            Text(text = "Sign Up")

            Spacer(modifier = Modifier.height(16.dp))
            TextButton(onClick = onNavigateToLogin) {
                Text(text = "Already have an account? Login")
            }
        }
    }
}
