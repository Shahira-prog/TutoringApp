package com.shahira.myuacademy.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.shahira.myuacademy.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(onSettingsClick: () -> Unit,
                onCrashCoursesClick: () -> Unit,
                onTutoringClick: () -> Unit,
                onHiringClick: () -> Unit
) {
    var expanded by remember { mutableStateOf(false) } //holds menu state
    TopAppBar(modifier = Modifier,
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,    // keep icon & text aligned
                modifier = Modifier.fillMaxWidth()
                //horizontalArrangement = Arrangement.Center         // center both in the bar
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logofinale),
                    contentDescription = "App logo",
                    modifier = Modifier
                        .size(42.dp)                               // pick whatever size you like
                       // .padding(end = 3.dp)
                )
                Text(
                    text = "MyU Academy",
                    modifier = Modifier.padding(start = 8.dp),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.headlineLarge.copy(
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Serif,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFFA5D6A7),
            titleContentColor = Color.White
        ),

        navigationIcon = {
            Box {
                IconButton(onClick = { expanded = true }) { // click triggers dropdown menu
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "dropdown menu",
                        tint = Color.Black
                    )
                }
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
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


    )
}