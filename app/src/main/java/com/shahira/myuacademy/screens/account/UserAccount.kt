package com.shahira.myuacademy.screens.account

import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.shahira.myuacademy.dataclasses.RegistrationEntity
import com.shahira.myuacademy.viewmodels.AuthViewModel
import com.shahira.myuacademy.viewmodels.RegistrationViewModel

@Composable
fun UserAccount(
    navController: NavHostController,
    onSignOut: () -> Unit,
    authViewModel: AuthViewModel = hiltViewModel(),
    registrationViewModel: RegistrationViewModel = hiltViewModel()
) {
    val currentAccount by remember { mutableStateOf(authViewModel.currentUser) }
    var showForm by remember { mutableStateOf(false) }
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf(0) }
    var gradeLevel by remember { mutableStateOf(0) }
    var dob by remember { mutableStateOf(0) }
    var selectedOption by remember { mutableStateOf("I Accept") }

    // Profile photo state and launcher
    var profileUri by rememberSaveable { mutableStateOf<Uri?>(null) }

    Scaffold { innerPadding ->
        // main content: profile picture, user info, sign out, register now
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(32.dp))

            //profile picture controls
            ProfilePhoto(
                selectedUri = profileUri,
                onImageSelected = { uri -> profileUri = uri }
            )
            Spacer(modifier = Modifier.height(10.dp))

            // user info
            Text(
                text = currentAccount?.name.toString(),
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = currentAccount?.email.toString(),
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(30.dp))

            // SIGN OUT
            Button(
                onClick = onSignOut,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.errorContainer,
                    contentColor = MaterialTheme.colorScheme.onErrorContainer
                )
            ) {
                Text("Sign Out")
            }

            Spacer(Modifier.height(26.dp))

            // REGISTER NOW
            Button(
                onClick = { showForm = true },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFA5D6A7),
                    contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            ) {
                Text("Register Now")
            }
        }

        // full screen registration form using dialog
        // dialog is used for pop ups
        if (showForm) {
            Dialog(
                onDismissRequest = { showForm = false }
            ) {
                // Surface so the dialog content can fill the screen
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    // but tapping outside or pressing register closes registration form
                    Registration(
                        modifier = Modifier.fillMaxSize(),
                        firstName = firstName,
                        onFirstNameChange = { firstName = it },
                        lastName = lastName,
                        onLastNameChange = { lastName = it },
                        email = email,
                        onEmailChange = { email = it },
                        phone = phone,
                        onPhoneChange = { phone = it },
                        gradeLevel = gradeLevel,
                        onGradeLevelChange = { gradeLevel = it },
                        dob = dob,
                        onDobChange = { dob = it },
                        selectedOption = selectedOption,
                        onOptionChange = { selectedOption = it },
                        onSend = {
                            registrationViewModel.saveRegistration(
                                RegistrationEntity(
                                    firstName = firstName,
                                    lastName = lastName,
                                    email = email,
                                    phone = phone,
                                    dob = dob,
                                    gradeLevel = gradeLevel,
                                    accepted = selectedOption == "I Accept"

                                )
                            )
                            showForm = false
                        }
                    )
                }
            }
        }
    }
}