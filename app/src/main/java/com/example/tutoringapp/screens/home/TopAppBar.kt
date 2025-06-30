package com.example.tutoringapp.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.example.tutoringapp.navigation.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(onSettingsClick: () -> Unit,
                onCrashCoursesClick: () -> Unit,
                onTutoringClick: () -> Unit,
                onHiringClick: () -> Unit
) {
    var expanded by remember { mutableStateOf(false) } //holds menu state
    TopAppBar(
        navigationIcon = {
            Box{
                IconButton(onClick = {expanded = true }) { // click triggers dropdown menu
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "dropdown menu",
                        tint = Color.Black
                    )
                }
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ){
                    DropdownMenuItem(
                        text = { Text("Crash Courses") },
                        onClick = { onCrashCoursesClick() }
                    )
                    DropdownMenuItem(
                        text = { Text("Tutoring") },
                        onClick = { onTutoringClick() }
                    )
                    DropdownMenuItem(
                        text = { Text("Hiring") },
                        onClick = { onHiringClick() }
                    )
                }
            }
        },
        title = {
            Text(
                text = "MyU Academy",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineLarge.copy(
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif,
                    color = MaterialTheme.colorScheme.onPrimary
                ))
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFFA5D6A7),
            titleContentColor = Color.White),

        actions = {
                IconButton(onClick = { onSettingsClick() }) {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "settings",
                        tint = Color.Black
                    )
                }

            })
        }