package com.shahira.myuacademy.screens.crashcourses
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController

@Composable
fun CrashCoursesScreen(navController: NavController) {

    var showCard by remember { mutableStateOf(false) }
    var showCard2 by remember { mutableStateOf(false) }
    var showCard3 by remember { mutableStateOf(false) }
    var showCard4 by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(16.dp).verticalScroll(rememberScrollState())) {
        Card(colors = CardDefaults.cardColors(containerColor = Color(0xFFA5D6A7))) {
            Row {
                Text(
                    text = "SAT English Prep",
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    modifier = Modifier.padding(30.dp)
                )
                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "$399",
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    modifier = Modifier.padding(30.dp)
                )
                Spacer(modifier = Modifier.weight(1f))
                // clickable button that says "Details"
                TextButton(
                    onClick = { showCard = true },
                    modifier = Modifier.align(Alignment.CenterVertically)) {
                    Text(
                        text = "Details",
                        color = Color.Blue,
                        fontSize = 17.sp,
                        //fontWeight = FontWeight.Bold,
                        textDecoration = TextDecoration.Underline
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Card(colors = CardDefaults.cardColors(containerColor = Color(0xFFA5D6A7))) {
            Row {
                Text(
                    text = "SAT Math Prep",
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    modifier = Modifier.padding(30.dp)                )
                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "$399",
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    modifier = Modifier.padding(30.dp)                )
                Spacer(modifier = Modifier.weight(1f))
                // clickable button that says "Details"
                TextButton(
                    onClick = { showCard2 = true },
                    modifier = Modifier.align(Alignment.CenterVertically)) {
                    Text(
                        text = "Details",
                        color = Color.Blue,
                        fontSize = 17.sp,
                        //fontWeight = FontWeight.Bold,
                        textDecoration = TextDecoration.Underline
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Card(colors = CardDefaults.cardColors(containerColor = Color(0xFFA5D6A7))) {
            Row {
                Text(
                    text = "Android Mobile\nApp Development",
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    modifier = Modifier.padding(30.dp)
                )
                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "$399",
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    modifier = Modifier.padding(top = 40.dp, end = 20.dp))
                Spacer(modifier = Modifier.weight(1f))
                // clickable button that says "book now"
                TextButton(
                    onClick = { showCard3 = true },
                    modifier = Modifier.align(Alignment.CenterVertically)) {
                    Text(
                        text = "Details",
                        color = Color.Blue,
                        fontSize = 17.sp,
                        //fontWeight = FontWeight.Bold,
                        textDecoration = TextDecoration.Underline
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Card(colors = CardDefaults.cardColors(containerColor = Color(0xFFA5D6A7))) {
            Row {
                Text(
                    text = "AMC8-10 Prep",
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    modifier = Modifier.padding(30.dp)                )
                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "$399",
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    modifier = Modifier.padding(30.dp)                )
                Spacer(modifier = Modifier.weight(1f))
                // clickable button that says "Details"
                TextButton(
                    onClick = { showCard4 = true },
                    modifier = Modifier.align(Alignment.CenterVertically)) {
                    Text(
                        text = "Details",
                        color = Color.Blue,
                        fontSize = 17.sp,
                        //fontWeight = FontWeight.Bold,
                        textDecoration = TextDecoration.Underline
                    )
                }
            }
        }
    }
    if (showCard) {
        Dialog(
            onDismissRequest = { showCard = false }
        ) {
            // Surface so the dialog content can fill the screen
            Surface(
                modifier = Modifier
                    .width(300.dp)           // or .fillMaxWidth(0.9f)
                    .wrapContentHeight()     // only as tall as your card needs
                    .padding(16.dp),
                tonalElevation = 8.dp,
                shape = RoundedCornerShape(12.dp)
            ) {
                // but tapping outside or pressing register closes registration form
                SATEnglishCard(navController = navController)
            }
        }
    }
    if (showCard2) {
        Dialog(
            onDismissRequest = { showCard2 = false }
        ) {
            // Surface so the dialog content can fill the screen
            Surface(
                modifier = Modifier
                    .width(300.dp)           // or .fillMaxWidth(0.9f)
                    .wrapContentHeight()     // only as tall as your card needs
                    .padding(16.dp),
                tonalElevation = 8.dp,
                shape = RoundedCornerShape(12.dp)
            ) {
                // but tapping outside or pressing register closes registration form
                SATMathCard(navController = navController)
            }
        }
    }
    if (showCard3) {
        Dialog(
            onDismissRequest = { showCard3 = false }
        ) {
            // Surface so the dialog content can fill the screen
            Surface(
                modifier = Modifier
                    .width(300.dp)           // or .fillMaxWidth(0.9f)
                    .wrapContentHeight()     // only as tall as your card needs
                    .padding(16.dp),
                tonalElevation = 8.dp,
                shape = RoundedCornerShape(12.dp)
            ) {
                // but tapping outside or pressing register closes registration form
                AMADCard(navController = navController)
            }
        }
    }
    if (showCard4) {
        Dialog(
            onDismissRequest = { showCard4 = false }
        ) {
            // Surface so the dialog content can fill the screen
            Surface(
                modifier = Modifier
                    .width(300.dp)           // or .fillMaxWidth(0.9f)
                    .wrapContentHeight()     // only as tall as your card needs
                    .padding(16.dp),
                tonalElevation = 8.dp,
                shape = RoundedCornerShape(12.dp)
            ) {
                // but tapping outside or pressing register closes registration form
                AMC8Card(navController = navController)
            }
        }
    }
}