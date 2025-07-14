package com.example.tutoringapp.screens.crashcourses

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tutoringapp.navigation.Screens

@Composable
fun AMADCard(navController: NavController)
{

    Card(modifier = Modifier.width(280.dp)
        .background(Color(0xFFA5D6A7))
        .padding(16.dp)
        .verticalScroll(rememberScrollState()),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFA5D6A7)))
    {
        Column{
            Text(text = "Android Mobile App Development",
                style = MaterialTheme.typography.headlineLarge.copy(
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontWeight = FontWeight.Bold,
                    textDecoration = TextDecoration.Underline)
            )
            Spacer(modifier = Modifier.height(40.dp))
            Text(
                text = "Android Mobile App Development with Kotlin (Java)",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(40.dp))
            Text(
                text = "Service Description",
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontWeight = FontWeight.Bold,
                    textDecoration = TextDecoration.Underline)
            )
            Spacer(modifier = Modifier.height(40.dp))
            Text(
                text = "Are you ready to turn your passion for mobile apps into real-world Android development skills? Whether you're a complete beginner, a programming enthusiast, or an experienced developer looking to transition into Android, this course has been meticulously crafted to guide you through the entire journey—step by step.\n" +
                        "\n" +
                        "This course offers a carefully structured, in-depth curriculum designed to take you from the very basics of Android app creation all the way to building fully functional, visually polished, and performance-optimized mobile applications using **Kotlin** and **Jetpack Compose**.\n" +
                        "\n" +
                        "Throughout the course, you’ll work on real-world projects that not only reinforce your learning but also give you a strong portfolio of apps you can showcase to employers, clients, or peers.\n" +
                        "\n" +
                        "What You’ll Learn\n" +
                        "\n" +
                        "By enrolling in this course, you’ll master a broad and practical set of skills, including:\n" +
                        "1. Installing and configuring Android Studio, the industry-standard IDE for Android.\n" +
                        "2. Working with Kotlin syntax and features including variables, loops, functions, and object-oriented principles\n" +
                        "3. Designing UI components using Composables\n" +
                        "4. Implementing navigation between screens\n" +
                        "5. Styling apps with custom themes, colors, and typography\n" +
                        "6. Introduction to Model-View-ViewModel (MVVM) and why it’s important\n" +
                        "7. Creating clean, testable, and scalable code\n" +
                        "8. Making HTTP requests using Retrofit, a popular HTTP client for Android\n" +
                        "9. Parsing JSON responses and binding data to UI\n" +
                        "10. Introduction to Room Database and SQLite\n" +
                        "11.Reading, writing, and updating records efficiently\n" +
                        "12. Synchronizing local data with online sources\n" +
                        "13. Building Real-World Projects, Android apps, such as Grocery App, News App, Move App from scratch",
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(22.dp))

            TextButton(onClick = { navController.navigate(Screens.Payment.route)},
                modifier = Modifier.align(Alignment.CenterHorizontally)){
                Text(text = "Book Now",
                    fontSize = 20.sp,
                    color = Color.Blue,
                    fontWeight = FontWeight.Bold,
                    textDecoration = TextDecoration.Underline)
            }

        }
    }
}
