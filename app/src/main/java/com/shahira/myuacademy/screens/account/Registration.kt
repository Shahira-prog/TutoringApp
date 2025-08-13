package com.shahira.myuacademy.screens.account

import android.util.Patterns
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
    phone: String = "",
    onPhoneChange: (String) -> Unit = {},
    gradeLevel: Int = 0,
    onGradeLevelChange: (Int) -> Unit = {},
    selectedOption: String,
    onOptionChange: (String) -> Unit,
    onSend: () -> Unit = {}
)
{

    var formError by remember { mutableStateOf<String?>(null) }

    // 1) Compute all validity flags here:
    val isEmailValid = email.isNotBlank() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    val isPhoneValid = phone.isNotBlank() && Patterns.PHONE.matcher(phone).matches()
    val isFormValid = firstName.isNotBlank()
            && lastName.isNotBlank()
            && isEmailValid
            && isPhoneValid
            && selectedOption == "I Accept"


    Card(modifier = Modifier.width(280.dp)
        .heightIn(max = 650.dp)             // ← cap the vertical size
        .background(Color.White)
        .padding(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)){
        Column {
            Text(
                text = "Registration",
                style = MaterialTheme.typography.headlineMedium.copy(
                    color = Color(0xFF125E12),
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

            EmailInput(
                email = email,
                onEmailChange = onEmailChange
            )

            Spacer(Modifier.height(8.dp))

            PhoneInput(
                phone = phone,
                onPhoneChange = onPhoneChange
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

            if (formError != null) {
                Text(
                    text = formError!!,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(vertical = 4.dp)
                )
            }

            Button(
                onClick = {
                    if (isFormValid) {
                        formError = null
                        onSend()
                    } else {
                        formError = "Please fill all fields correctly and accept the terms."
                    }
                },
                enabled = isFormValid,
                modifier = Modifier.align(Alignment.End),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF125E12),
                    contentColor = Color.White
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
            Text("Cancel/reschedule 8 hours in advance notification required",
                color = Color.Red,
                fontSize = 13.sp,
                modifier = Modifier.padding(6.dp),
                fontStyle = FontStyle.Italic)

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
    phone: String = "",
    onPhoneChange: (String) -> Unit = {},
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
                .fillMaxWidth()
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
fun isValidEmail(email: String): Boolean =
    Patterns.EMAIL_ADDRESS.matcher(email).matches()

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailInput(
    email: String,
    onEmailChange: (String) -> Unit
) {
    var isError by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = email,
        onValueChange = {
            onEmailChange(it)
            isError = it.isNotBlank() && !isValidEmail(it)
        },
        label = { Text("Email") },
        isError = isError,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        modifier = Modifier.fillMaxWidth(),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = Color.White
        )
    )

    AnimatedVisibility(visible = isError) {
        Text(
            text = "Please enter a valid email address",
            color = MaterialTheme.colorScheme.error,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(start = 16.dp, top = 4.dp)
        )
    }
}
fun isValidPhoneNumber(phone: String): Boolean =
    Patterns.PHONE.matcher(phone).matches() && phone.length >= 10

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PhoneInput(
    phone: String,
    onPhoneChange: (String) -> Unit
) {
    var isError by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = phone,
        onValueChange = {
            onPhoneChange(it)
            isError = it.isNotBlank() && !isValidPhoneNumber(it)
        },
        label = { Text("Phone") },
        isError = isError,
        singleLine = false,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        modifier = Modifier.fillMaxWidth(),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = Color.White
        )
    )
    AnimatedVisibility(visible = isError) {
        Text(
            text = "Please enter a valid phone number",
            color = MaterialTheme.colorScheme.error,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(start = 16.dp, top = 4.dp)
        )
    }
}
