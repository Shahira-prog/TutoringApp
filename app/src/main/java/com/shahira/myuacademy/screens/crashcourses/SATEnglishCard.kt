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
fun SATEnglishCard(navController: NavController)
{

    Card(modifier = Modifier.width(280.dp)
        .background(Color(0xFFA5D6A7))
        .padding(16.dp)
        .verticalScroll(rememberScrollState()),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFA5D6A7)))
    {
        Column{
            Text(text = "SAT English Prep",
                style = MaterialTheme.typography.headlineLarge.copy(
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontWeight = FontWeight.Bold,
                    textDecoration = TextDecoration.Underline)
            )
            Spacer(modifier = Modifier.height(40.dp))
            Text(
                text = "The Official Digital SAT Study Guide™ - four official practice tests―all created by the test maker.",
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
                text = "The Official Digital SAT Study Guide™ provides a comprehensive resource for understanding updates to the SAT® in the digital format. It includes four official practice tests―all created by the test maker. As part of College Board’s commitment to access, practice tests are also available in the digital testing platform, Bluebook™, at no charge. However, the guide is the only place to find practice tests in print accompanied by over 300 pages of additional instruction, guidance, and test information.\n" +
                        "\n" +
                        "The Official Digital SAT Study Guide will help students get ready for the digital SAT with:\n" +
                        "• four official digital SAT practice tests, created from the same process used for the actual test.\n" +
                        "• detailed descriptions of the Reading and Writing and Math sections of the digital SAT.\n" +
                        "• targeted sample questions for each question type.\n" +
                        "• question drills by topic.\n" +
                        "• test-taking approaches and suggestions.\n" +
                        "• detailed explanations of right and wrong answers.\n" +
                        "• information on preparing for the digital PSAT/NMSQT® or PSAT™ 10.",
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
