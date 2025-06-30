package com.example.tutoringapp.screens.account

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tutoringapp.dataclasses.UserAccounts

@Composable
fun UserAccount(navController: NavController, onSignOut: () -> Unit) // call back for sign out action
{
    // get current account (mock user 06/27/2025)
    val currentAccount = UserAccounts("03", "Satoru Gojo", "satoru@gojo.com" )

    Column(modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        // profile header
        Spacer(modifier = Modifier.height(32.dp))

        // profile picture
        Box(
            modifier = Modifier.size(120.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primaryContainer),
            contentAlignment = Alignment.Center
        ){
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Profile Picture",
                modifier = Modifier.size(80.dp),
                tint = MaterialTheme.colorScheme.primary

            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // user info
        Text(
            text = currentAccount.name,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = currentAccount.email,
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        // sign out button
        Button(
            onClick = onSignOut,
            modifier = Modifier.align(Alignment.CenterHorizontally)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.errorContainer,
                contentColor = MaterialTheme.colorScheme.onErrorContainer
            )
        ){
            Text("Sign Out", modifier = Modifier.padding(4.dp))
        }

    }
}