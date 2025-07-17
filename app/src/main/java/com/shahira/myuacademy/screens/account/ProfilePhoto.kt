package com.shahira.myuacademy.screens.account

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color

@Composable
fun ProfilePhoto(
    selectedUri: Uri?,
    onImageSelected: (Uri) -> Unit
) {
    // 1) Remember a launcher for the “pick content” contract
    val galleryLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let(onImageSelected)
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        // 2) Show the picked image if we have one
        if (selectedUri != null) {
            // use Coil or AsyncImage to load the URI
            AsyncImage(
                model    = selectedUri,
                contentDescription = "Profile Photo",
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
            )
        } else {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Profile Picture",
                modifier = Modifier.size(80.dp),
                tint = MaterialTheme.colorScheme.primary

            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // 3) Button to launch gallery picker
        Button(onClick = { galleryLauncher.launch("image/*") },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFA5D6A7),
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer
            )) {
            Text("Upload Photo")
        }
    }
}
