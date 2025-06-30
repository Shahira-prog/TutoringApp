package com.example.tutoringapp.screens.crashcourses
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tutoringapp.navigation.Screens

@Composable
fun CrashCoursesScreen(navController: NavController) {
    Text(
        text = "Crash Courses",
        fontSize = 35.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )
    Column(modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.Start) {

        Spacer(modifier = Modifier.height(50.dp))

        Row {
            Text(
                text = "Course",
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp
            )
            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "Price",
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Booking",
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp
            )
        }
            Spacer(modifier = Modifier.height(50.dp))

        Row {
            Text(text = "SAT English Prep",
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp)
            Spacer(modifier = Modifier.weight(1f))

            Text(text = "$399",
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp)
            Spacer(modifier = Modifier.weight(1f))
            // clickable button that says "book now"
            Button(onClick = { navController.navigate(Screens.Payment.route)},
                modifier = Modifier.width(100.dp).height(40.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFA5D6A7),
                    contentColor = Color.Black)
                ) {
                Text(text = "Book")
            }
        }
        Spacer(modifier = Modifier.height(120.dp))

        Row {
            Text(text = "SAT Math Prep",
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp)
            Spacer(modifier = Modifier.weight(1f))

            Text(text = "$399",
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp)
            Spacer(modifier = Modifier.weight(1f))
            // clickable button that says "book now"
            Button(onClick = { navController.navigate(Screens.Payment.route)},
                modifier = Modifier.width(100.dp).height(40.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFA5D6A7),
                    contentColor = Color.Black)
            ) {
                Text(text = "Book")
            }
        }
        Spacer(modifier = Modifier.height(120.dp))

        Row {
            Text(text = "Android Mobile\nApp Development",
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp)
            Spacer(modifier = Modifier.weight(1f))

            Text(text = "$399",
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp)
            Spacer(modifier = Modifier.weight(1f))
            // clickable button that says "book now"
            Button(onClick = { navController.navigate(Screens.Payment.route)},
                modifier = Modifier.width(100.dp).height(40.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFA5D6A7),
                    contentColor = Color.Black)
            ) {
                Text(text = "Book")
            }
        }
        Spacer(modifier = Modifier.height(120.dp))

        Row {
            Text(text = "AMC8-10 Prep",
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp)
            Spacer(modifier = Modifier.weight(1f))

            Text(text = "$399",
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp)
            Spacer(modifier = Modifier.weight(1f))
            // clickable button that says "book now"
            Button(onClick = { navController.navigate(Screens.Payment.route)},
                modifier = Modifier.width(100.dp).height(40.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFA5D6A7),
                    contentColor = Color.Black)
            ) {
                Text(text = "Book")
            }
        }
    }
}