package com.example.tutoringapp.screens.account

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.tutoringapp.viewmodels.AuthViewModel
import com.example.tutoringapp.viewmodels.RegistrationViewModel

@Composable
fun AdminAccount(
    navController: NavHostController,
    onSignOut: () -> Unit,
    authViewModel: AuthViewModel = hiltViewModel(),
    registrationViewModel: RegistrationViewModel = hiltViewModel()
) {
    val currentAccount by remember { mutableStateOf(authViewModel.currentUser) }
    // Profile photo state and launcher
    var profileUri by rememberSaveable { mutableStateOf<Uri?>(null) }


    Scaffold { innerPadding ->
        var showUsers by remember { mutableStateOf(false) }
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

            Text(
                text = "Admin",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))

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
        Spacer(Modifier.height(16.dp))
            Button(onClick = { showUsers = !showUsers },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFA5D6A7),
                    contentColor   = MaterialTheme.colorScheme.onPrimaryContainer
                )) {
                Text(if (showUsers) "Hide Users" else "Show Users")
            }

            Spacer(Modifier.height(16.dp))

            if (showUsers) {
                // 1) collect the Flow from Room as State
                val registrations by registrationViewModel
                    .getAllRegistrations()                            // Flow<List<RegistrationEntity>>
                    .collectAsStateWithLifecycle(emptyList())         // lifecycle-aware :contentReference[oaicite:0]{index=0}

                // 2) render each entry in a LazyColumn
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(registrations, key = { it.id }) { reg ->
                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            elevation = CardDefaults.cardElevation(4.dp)
                        ) {
                            Column(Modifier.padding(12.dp)) {
                                Text(
                                    "${reg.firstName} ${reg.lastName}",
                                    style = MaterialTheme.typography.headlineSmall
                                )
                                Text(reg.email, style = MaterialTheme.typography.bodyLarge)
                                Text(
                                    "Phone: ${reg.phone}",
                                    style = MaterialTheme.typography.bodyMedium
                                )
                                Text("DOB: ${reg.dob}", style = MaterialTheme.typography.bodyMedium)
                                Text(
                                    "Grade: ${reg.gradeLevel}",
                                    style = MaterialTheme.typography.bodyMedium
                                )
                                Text(
                                    "Accepted: ${if (reg.accepted) "Yes" else "No"}",
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            }
                        }
                    }
                }
            }
            }
        }
    }
