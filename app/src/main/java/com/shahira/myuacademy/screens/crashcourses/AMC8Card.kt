package com.shahira.myuacademy.screens.crashcourses

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
import com.shahira.myuacademy.navigation.Screens

@Composable
fun AMC8Card(navController: NavController)
{

    Card(modifier = Modifier.width(280.dp)
        .background(Color(0xFFA5D6A7))
        .padding(16.dp)
        .verticalScroll(rememberScrollState()),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFA5D6A7)))
    {
        Column{
            Text(text = "AMC8-10 Prep",
                style = MaterialTheme.typography.headlineLarge.copy(
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontWeight = FontWeight.Bold,
                    textDecoration = TextDecoration.Underline)
            )
            Spacer(modifier = Modifier.height(40.dp))
            Text(
                text = "The goal is to promote the development and enhancement of problem-solving skills",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Available Online!",
                fontSize = 12.sp,
                color = Color.Red
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
                text = "Middle School and Junior High Mathematics Challenge- GRADE 7-10\n" +
                        "The AMC 10 is a 25-question, 75-minute, multiple-choice examinations in high school mathematics designed to promote the development and enhancement of problem-solving skills.\n" +
                        "\n" +
                        "The AMC 10 is for students in 10th grade and below and covers the high school curriculum up to 10th grade. Students in grade 10 or below and under 17.5 years of age on the day of the contest can take the AMC 10.\n" +
                        "The AMC 10/12 is the first in a series of competitions that eventually lead all the way to the International Mathematical Olympiad (Source: Mathematical Association of America).\n" +
                        "\n" +
                        "This book is a great resource for students who take some well-known middle and junior high school mathematics contests such as American Mathematics Competitions (AMC-8/10), MathCON Finals, MATHCOUNTS®, and Math Leagues. It contains 10 practice tests and their full detailed solutions. The author, Dr. Sinan Kanbir, has extensive experience in math contest preparation and teaching mathematically promising students. Dr. Kanbir is the author and co-author of four research and teaching books and several publications about teaching and learning mathematics. He is an item writer for Central Wisconsin Math League (CWML), MathCON, and the Wisconsin section of the MAA math contest.",
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
