package com.shahira.myuacademy.screens.account

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
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
import androidx.compose.material3.RadioButton
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Registration(
    modifier: Modifier = Modifier,
    firstName: String = "",
    onFirstNameChange: (String) -> Unit = {},
    lastName: String = "",
    onLastNameChange: (String) -> Unit = {},
    email: String = "",
    onEmailChange: (String) -> Unit = {},
    phone: Int = 0,
    onPhoneChange: (Int) -> Unit = {},
    dob: Int = 0,
    onDobChange: (Int) -> Unit = {},
    gradeLevel: Int = 0,
    onGradeLevelChange: (Int) -> Unit = {},
    selectedOption: String,
    onOptionChange: (String) -> Unit,
    onSend: () -> Unit = {}
)
{
    Card(modifier = Modifier.width(280.dp)
        .clip(RoundedCornerShape(16.dp))            // rounded corners
        .background(Color(0xFFA5D6A7))
        .padding(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFA5D6A7))){
        Column {
            Text(
                text = "Registration",
                style = MaterialTheme.typography.headlineMedium.copy(
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontWeight = FontWeight.Bold)
            )

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value            = firstName,
                onValueChange    = onFirstNameChange,
                label            = { Text("First Name") },
                singleLine       = true,
                modifier         = Modifier.fillMaxWidth(),
                colors           = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color.White
                )
            )

            Spacer(Modifier.height(8.dp))

            OutlinedTextField(
                value            = lastName,
                onValueChange    = onLastNameChange,
                label            = { Text("Last Name") },
                singleLine       = true,
                modifier         = Modifier.fillMaxWidth(),
                colors           = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color.White
                )
            )

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
                value            = dob.toString(),
                onValueChange    = {onDobChange(it.toIntOrNull() ?: 0)},
                label            = { Text("Date of Birth") },
                singleLine       = false,
                modifier         = Modifier.fillMaxWidth(),
                keyboardOptions  = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors           = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color.White
                )
            )

            Spacer(Modifier.height(8.dp))

            OutlinedTextField(
                value            = gradeLevel.toString(),
                onValueChange    = {onGradeLevelChange(it.toIntOrNull() ?: 0)},
                label            = { Text("Grade Level") },
                singleLine       = false,
                modifier         = Modifier.fillMaxWidth(),
                keyboardOptions  = KeyboardOptions(keyboardType = KeyboardType.Number),
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
                    Text("Register")
                }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (selectedOption == "I Accept"),
                    onClick  = { onOptionChange("I Accept") }
                )
                Text("I agree", modifier = Modifier.padding(end = 8.dp))

                RadioButton(
                    selected = (selectedOption == "I Do Not Accept"),
                    onClick  = { onOptionChange("I Do Not Accept") }
                )
                Text("I disagree")

                // push the button to the far end
                Spacer(Modifier.weight(1f))
            }

        }
    }
}
@Composable
fun RegistrationFabScreen(
    firstName: String = "",
    onFirstNameChange: (String) -> Unit = {},
    lastName: String = "",
    onLastNameChange: (String) -> Unit = {},
    email: String = "",
    onEmailChange: (String) -> Unit = {},
    phone: Int = 0,
    onPhoneChange: (Int) -> Unit = {},
    gradeLevel: Int = 0,
    onGradeLevelChange: (Int) -> Unit = {},
    dob: Int = 0,
    onDobChange: (Int) -> Unit = {},
    onSend: () -> Unit = {}
) {
    var showForm by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("I Accept") }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showForm = !showForm },
                containerColor = Color(0xFFA5D6A7)
            ) {
                Icon(
                    imageVector = if (showForm) Icons.Default.Close else Icons.Default.Email,
                    contentDescription = "Register Now"
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
                com.shahira.myuacademy.screens.account.Registration(
                    modifier = Modifier.padding(top = 16.dp),
                    firstName = firstName,
                    onFirstNameChange = onFirstNameChange,
                    lastName = lastName,
                    onLastNameChange = onLastNameChange,
                    email = email,
                    onEmailChange = onEmailChange,
                    phone = phone,
                    onPhoneChange = onPhoneChange,
                    gradeLevel = gradeLevel,
                    onGradeLevelChange = onGradeLevelChange,
                    dob = dob,
                    onDobChange = onDobChange,
                    selectedOption = selectedOption,
                    onOptionChange = { selectedOption = it },
                    onSend = {
                        onSend()
                        showForm = false
                    }
                )
            }

        }
    }
}