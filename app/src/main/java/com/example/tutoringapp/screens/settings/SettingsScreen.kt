package com.example.tutoringapp.screens.settings

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun SettingsScreen(navController: NavController) {
    Text(modifier = Modifier.fillMaxSize().padding(35.dp),
        textAlign = TextAlign.Center,
        text = "Settings Screen: CURRENTLY EMPTY",
        fontSize = 40.sp,
        fontWeight = FontWeight.Bold)
}