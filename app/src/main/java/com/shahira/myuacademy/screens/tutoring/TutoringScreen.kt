package com.shahira.myuacademy.screens.tutoring

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.layout.layout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.shahira.myuacademy.navigation.Screens
import com.shahira.myuacademy.screens.settings.SettingsScreen


@Composable
fun TutoringScreen(navController: NavHostController) {
    var showCard by remember { mutableStateOf(false) }
    var showCard2 by remember { mutableStateOf(false) }
    var showCard3 by remember { mutableStateOf(false) }


    Scaffold(
    ) { innerPadding ->
        Box(
            Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.TopCenter
        ) {
            val scrollState = rememberScrollState()
            Column(
                modifier = Modifier
                    .verticalScroll(scrollState)
            ) {
                Text(
                    text = "One-On-One Tutoring \n Plan and Price",
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth().padding(16.dp)
                        .clickable(
                            onClick = {
                            })
                )
                Spacer(modifier = Modifier.height(1.dp))

                Text(
                    text = "One-on-one tutoring that can take place " +
                            "in person at our MyU Academt tutoring center (Near the NOVA Loudoun Campus)" +
                            " or face to face online (Zoom) with an affordable rates which " +
                            "starts from $35 per hour. For new students," +
                            "we are glad to offer a free 30-minute session before purchasing any plans. \n" +
                            "\nPlease don't hesitate to reach out us now If you " +
                            "have questions or are interested in our services.",
                    fontSize = 18.sp,
                    textAlign = TextAlign.Left,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.fillMaxWidth().padding(16.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))

                Column(modifier = Modifier.padding(16.dp).fillMaxWidth(),) {

                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors()
                    )
                    {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Text(
                                text = "Plan",
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                modifier = Modifier.padding(10.dp)
                            )

                            Text(
                                text = "Price",
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp,
                                modifier = Modifier.padding(10.dp)
                            )

                            Text(
                                text = "Valid ",
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp,
                                modifier = Modifier.padding(10.dp)
                            )

                            Text(
                                text = "Refund",
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp,
                                modifier = Modifier.padding(10.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.padding(2.dp))
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors()
                    )
                    {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Text(
                                text = "1  Hour",
                                fontWeight = FontWeight.Normal,
                                fontSize = 15.sp,
                                modifier = Modifier.padding(10.dp)
                            )

                            Text(
                                text = "$ 59",
                                fontWeight = FontWeight.Normal,
                                fontSize = 15.sp,
                                modifier = Modifier.padding(10.dp)
                            )

                            Text(
                                text = "6 Month",
                                fontWeight = FontWeight.Normal,
                                fontSize = 15.sp,
                                modifier = Modifier.padding(10.dp)
                            )

                            Text(
                                text = "None",
                                fontWeight = FontWeight.Normal,
                                fontSize = 15.sp,
                                modifier = Modifier.padding(10.dp)
                            )

                        }
                    }
                    Spacer(modifier = Modifier.padding(2.dp))
                    Card(modifier = Modifier.fillMaxWidth(), colors = CardDefaults.cardColors())
                    {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Text(
                                text = "5  Hour",
                                fontWeight = FontWeight.Normal,
                                fontSize = 15.sp,
                                modifier = Modifier.padding(10.dp)
                            )

                            Text(
                                text = "$225",
                                fontWeight = FontWeight.Normal,
                                fontSize = 15.sp,
                                modifier = Modifier.padding(10.dp)
                            )

                            Text(
                                text = "6 Month",
                                fontWeight = FontWeight.Normal,
                                fontSize = 15.sp,
                                modifier = Modifier.padding(10.dp)
                            )

                            Text(
                                text = "None",
                                fontWeight = FontWeight.Normal,
                                fontSize = 15.sp,
                                modifier = Modifier.padding(10.dp)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.padding(2.dp))
                    Card(modifier = Modifier.fillMaxWidth(), colors = CardDefaults.cardColors())
                    {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Text(
                                text = "10 Hour",
                                fontWeight = FontWeight.Normal,
                                fontSize = 15.sp,
                                modifier = Modifier.padding(10.dp)
                            )

                            Text(
                                text = "$399",
                                fontWeight = FontWeight.Normal,
                                fontSize = 15.sp,
                                modifier = Modifier.padding(10.dp)
                            )

                            Text(
                                text = "6 Month",
                                fontWeight = FontWeight.Normal,
                                fontSize = 15.sp,
                                modifier = Modifier.padding(10.dp)
                            )

                            Text(
                                text = "None",
                                fontWeight = FontWeight.Normal,
                                fontSize = 15.sp,
                                modifier = Modifier.padding(10.dp)
                            )
                        }

                    }

                    Spacer(modifier = Modifier.padding(10.dp))
                    Text(
                        text = "Schedule:",
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp,
                        modifier = Modifier.padding(5.dp)
                    )

                    Text(
                        text = "Based on over twelve years of experience, MyU " +
                                "recommends that students visit the tutoring office for at least two " +
                                "hours per week on different days. This approach has proven to be " +
                                "the most effective in improving academic performance. MyU " +
                                "encourages a consistent weekly schedule—for example, every " +
                                "Monday and Wednesday from 4:00 PM to 5:00 PM. After a " +
                                "student purchases a plan, their schedule will be set in " +
                                "consultation with them. Naturally, sessions can be rescheduled " +
                                "or canceled at any time in accordance with the cancellation policy. ",
                        fontWeight = FontWeight.Normal,
                        fontSize = 15.sp,
                        modifier = Modifier.padding(5.dp).fillMaxWidth()
                    )

                    //Spacer(modifier = Modifier.padding(5.dp))
                    Text(
                        text = "Cancellation Policy:",
                        // textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp,
                        modifier = Modifier.padding(5.dp).fillMaxWidth()
                    )

                    Text(
                        text = "In accordance with company policy, cancellations must be made" +
                                " at least 8 hours in advance. Failure to do so will result in a charge" +
                                " equivalent to a one-hour session, except in cases of verified " +
                                "emergencies. We appreciate your understanding and cooperation " +
                                "in helping us manage our schedule efficiently and maintain a high" +
                                " standard of service for all clients.",
                        fontWeight = FontWeight.Normal,
                        fontSize = 15.sp,
                        modifier = Modifier.padding(5.dp).fillMaxWidth()
                    )

                    Text(
                        text = "Tutoring Levels:",
                        fontWeight = FontWeight.Bold,
                        //textAlign = TextAlign.Center,
                        fontSize = 15.sp,
                        modifier = Modifier.padding(5.dp).fillMaxWidth()
                    )

                    Text(
                        text = "We offer tutoring for students at all academic levels, including" +
                                " elementary school, middle school, high school, college, and beyond.",
                        fontWeight = FontWeight.Normal,
                        fontSize = 15.sp,
                        modifier = Modifier.padding(5.dp).fillMaxWidth()
                    )

                    Text(
                        text = "Subjects Offered:",
                        fontWeight = FontWeight.Bold,
                        //textAlign = TextAlign.Center,
                        fontSize = 15.sp,
                        modifier = Modifier.padding(5.dp).fillMaxWidth()
                    )

                    Text(
                        text =
                            "Elementary School:",
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp,
                        modifier = Modifier.padding(5.dp).fillMaxWidth()
                    )

                    Text(
                        text = "Math, English, Science, and more.",
                        fontWeight = FontWeight.Normal,
                        fontSize = 15.sp,
                        modifier = Modifier.padding(5.dp)
                    )

                    Text(
                        text =
                            "Middle School:",
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp,
                        modifier = Modifier.padding(5.dp).fillMaxWidth()
                    )

                    Text(
                        text = "Pre-Algebra, Algebra I & II, Geometry, English, Science, and more.",
                        fontWeight = FontWeight.Normal,
                        fontSize = 15.sp,
                        modifier = Modifier.padding(5.dp).fillMaxWidth()
                    )

                    Text(
                        text = "High School:",
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp,
                        modifier = Modifier.padding(5.dp).fillMaxWidth()
                    )

                    Text(
                        text = "Precalculus, AP Precalculus, Trigonometry, " +
                                "AP Calculus AB & BC, Vector (Multivariable) Calculus, " +
                                "Linear Algebra, Statistics (including Data Science), " +
                                "Chemistry, Physics, English, and more",
                        fontWeight = FontWeight.Normal,
                        fontSize = 15.sp,
                        modifier = Modifier.padding(5.dp).fillMaxWidth()
                    )

                    Text(
                        text = "College:",
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp,
                        modifier = Modifier.padding(5.dp).fillMaxWidth()
                    )

                    Text(
                        text = "Quantitative Reasoning, Statistics, Precalculus, " +
                                "Trigonometry, Calculus I, II, III, Linear Algebra, " +
                                "Differential Equations, Science",
                        fontWeight = FontWeight.Normal,
                        fontSize = 15.sp,
                        modifier = Modifier.padding(5.dp).fillMaxWidth()
                    )

                    Text(
                        text = "ESL (English Second Language):",
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp,
                        modifier = Modifier.padding(5.dp).fillMaxWidth()
                    )

                    Text(
                        text = "English Conversation (Speaking) Level I, II. III\n" +
                                "Writing and Reading  English Level I, II, III. ",
                        fontWeight = FontWeight.Normal,
                        fontSize = 15.sp,
                        modifier = Modifier.padding(5.dp).fillMaxWidth()
                    )

                }
            }
        }
    }
}










//    Scaffold(
//    ) { innerPadding ->
//        Box(
//            Modifier
//                .fillMaxSize()
//                .padding(innerPadding),
//            contentAlignment = Alignment.TopCenter
//        ) {
//    val scrollState = rememberScrollState()
//    Column(
//        modifier = Modifier
//            .verticalScroll(scrollState)) {
//                Text(
//            text = "One-On-One Tutoring \n Plan and Price",
//            fontSize = 20.sp,
//            textAlign = TextAlign.Center,
//            fontWeight = FontWeight.Bold,
//            modifier = Modifier.fillMaxWidth().padding(16.dp)
//                .clickable(
//                    onClick = {
//
//
//                        //OneHourCard(navController = navController)
//                    })
//        )
//
//
////        NavHost(
////            navController = navController,
////            startDestination = Screens.Home.route,
////            modifier = Modifier
////                .fillMaxSize()
////            //.padding(innerPadding)
////        ) {
////
////            Text(text="test",Modifier.clickable(onClick ={
////                composable(Screens.Settings.route) {
////
////                    SettingsScreen(navController = navController)
////                }
////            } ))
////
////        }
//        Spacer(modifier = Modifier.height(1.dp))
//
//        Text(
//            text = "One-on-one tutoring that can take place " +
//                    "in person at our tutoring center (Near the NOVA Loudoun Campus)" +
//                    " or face to face online (Zoom) with an affordable rates which " +
//                    "starts from $35 per hour. For new students, upon request, f" +
//                    "we are glad to offer a free 30-minute session before purchasing any plans. \n" +
//                    "Please don't hesitate to reach out us now If you " +
//                    "have questions or are interested in our services.",
//            fontSize = 18.sp,
//            textAlign = TextAlign.Left,
//            fontWeight = FontWeight.Normal,
//            modifier = Modifier.fillMaxWidth().padding(16.dp)
//        )
////
////        Spacer(modifier = Modifier.height(11.dp))
////
////        Text(
////            text = "Note: Before purchasing, please contact us for the availability and payment options, we accept Zelle and Venmo as well.",
////            fontSize = 13.sp,
////            fontWeight = FontWeight.Bold,
////            textAlign = TextAlign.Center,
////            color = Color.Red,
////            modifier = Modifier.fillMaxWidth()
////        )
//        Spacer(modifier = Modifier.height(10.dp))
//
//        Column(modifier = Modifier.padding(16.dp).fillMaxWidth(),) {
//
//            Card(modifier = Modifier.fillMaxWidth(),
//                colors = CardDefaults.cardColors())
//            {
//                Row (
//                    modifier = Modifier.fillMaxWidth(),
//                    horizontalArrangement = Arrangement.SpaceEvenly,
//                    verticalAlignment = Alignment.CenterVertically, ){
//                    Text(
//                        text = "Plan",
//                        fontWeight = FontWeight.Bold,
//                        fontSize = 20.sp,
//                        modifier = Modifier.padding(10.dp)
//                    )
//
//                    Text(
//                        text = "Price",
//                        fontWeight = FontWeight.Bold,
//                        fontSize = 15.sp,
//                        modifier = Modifier.padding(10.dp)
//                    )
//
//                    Text(
//                        text = "Valid",
//                        fontWeight = FontWeight.Bold,
//                        fontSize = 15.sp,
//                        modifier = Modifier.padding(10.dp)
//                    )
//
//                    Text(
//                        text = "Refund",
//                        fontWeight = FontWeight.Bold,
//                        fontSize = 15.sp,
//                        modifier = Modifier.padding(10.dp)
//                    )
//                }
//            }
//
//            Spacer(modifier = Modifier.padding(10.dp))
//            Card(modifier = Modifier.fillMaxWidth(),
//                colors = CardDefaults.cardColors())
//            {
//                Row (
//                    modifier = Modifier.fillMaxWidth(),
//                    horizontalArrangement = Arrangement.SpaceEvenly,
//                    verticalAlignment = Alignment.CenterVertically, ){
//                    Text(
//                        text = "1 Hour",
//                        fontWeight = FontWeight.Normal,
//                        fontSize = 15.sp,
//                        modifier = Modifier.padding(10.dp)
//                    )
//
//                    Text(
//                        text = "$59",
//                        fontWeight = FontWeight.Normal,
//                        fontSize = 15.sp,
//                        modifier = Modifier.padding(10.dp)
//                    )
//
//                    Text(
//                        text = "6 Months",
//                        fontWeight = FontWeight.Normal,
//                        fontSize = 15.sp,
//                        modifier = Modifier.padding(10.dp)
//                    )
//
//                    Text(
//                        text = "Non refund",
//                        fontWeight = FontWeight.Normal,
//                        fontSize = 15.sp,
//                        modifier = Modifier.padding(10.dp)
//                    )
//
//                }
//            }
//            Spacer(modifier = Modifier.padding(10.dp))
//            Card(modifier = Modifier.fillMaxWidth(), colors = CardDefaults.cardColors())
//            {
//                Row (modifier = Modifier.fillMaxWidth(),
//                    horizontalArrangement = Arrangement.SpaceEvenly,
//                    verticalAlignment = Alignment.CenterVertically, ){
//                    Text(
//                        text = "5 Hour",
//                        fontWeight = FontWeight.Normal,
//                        fontSize = 15.sp,
//                        modifier = Modifier.padding(10.dp)
//                    )
//
//                    Text(
//                        text = "$225",
//                        fontWeight = FontWeight.Normal,
//                        fontSize = 15.sp,
//                        modifier = Modifier.padding(10.dp)
//                    )
//
//                    Text(
//                        text = "6 Months",
//                        fontWeight = FontWeight.Normal,
//                        fontSize = 15.sp,
//                        modifier = Modifier.padding(10.dp)
//                    )
//
//                    Text(
//                        text = "Non refund",
//                        fontWeight = FontWeight.Normal,
//                        fontSize = 15.sp,
//                        modifier = Modifier.padding(10.dp)
//                    )
//                }
//            }
//            Spacer(modifier = Modifier.padding(10.dp))
//            Card(modifier = Modifier.fillMaxWidth(), colors = CardDefaults.cardColors())
//            {
//                Row (modifier = Modifier.fillMaxWidth(),
//                    horizontalArrangement = Arrangement.SpaceEvenly,
//                    verticalAlignment = Alignment.CenterVertically, ){
//                    Text(
//                        text = "10 Hour",
//                        fontWeight = FontWeight.Normal,
//                        fontSize = 15.sp,
//                        modifier = Modifier.padding(10.dp)
//                    )
//
//                    Text(
//                        text = "$399",
//                        fontWeight = FontWeight.Normal,
//                        fontSize = 15.sp,
//                        modifier = Modifier.padding(10.dp)
//                    )
//
//                    Text(
//                        text = "6 Months",
//                        fontWeight = FontWeight.Normal,
//                        fontSize = 15.sp,
//                        modifier = Modifier.padding(10.dp)
//                    )
//
//                    Text(
//                        text = "Non refund",
//                        fontWeight = FontWeight.Normal,
//                        fontSize = 15.sp,
//                        modifier = Modifier.padding(10.dp)
//                    )
//                }
//                //SimpleTable()
//            }
////                        //Spacer(modifier = Modifier.padding(20.dp))
//////                        TextButton(
//////                            onClick = { navController.navigate(Screens.OneHour.route) },
//////                            modifier = Modifier.align(Alignment.CenterVertically)
//////                        ) {
//////                            Text(
//////                                text = "Plan Details",
//////                                color = Color.Blue,
//////                                fontWeight = FontWeight.Bold,
//////                                textDecoration = TextDecoration.Underline
//////                            )
//////                        }
//////                        Spacer(modifier = Modifier.padding(10.dp))
//////
//////                        Row {
//////                            Text(
//////                                text = "1 Hour",
//////                                fontWeight = FontWeight.Bold,
//////                                fontSize = 20.sp,
//////                                modifier = Modifier.padding(30.dp)
//////                            )
//////                            Spacer(modifier = Modifier.padding(20.dp))
//////                            TextButton(
//////                                onClick = { navController.navigate(Screens.OneHour.route) },
//////                                modifier = Modifier.align(Alignment.CenterVertically)
//////                            ) {
//////                                Text(
//////                                    text = "Plan Details",
//////                                    color = Color.Blue,
//////                                    fontWeight = FontWeight.Bold,
//////                                    textDecoration = TextDecoration.Underline
//////                                )
//////                            }
//////                            Spacer(modifier = Modifier.padding(18.dp))
////////                    TextButton(
////////                        onClick = { showCard = true },
////////                        modifier = Modifier.align(Alignment.CenterVertically)
////////                    ) {
////////                        Text(
////////                            text = "Details",
////////                            color = Color.Blue,
////////                            textDecoration = TextDecoration.Underline
////////                        )
////////                    }
//////                            //Spacer(modifier = Modifier.padding(16.dp))
//////                        }
////
////
////                    Spacer(modifier = Modifier.padding(16.dp))
////
////                    Card(colors = CardDefaults.cardColors(containerColor = Color(0xFFA5D6A7))) {
////                        Row {
////                            Text(
////                                text = "5 Hours",
////                                fontWeight = FontWeight.Bold,
////                                fontSize = 20.sp,
////                                modifier = Modifier.padding(30.dp)
////                            )
////                            Spacer(modifier = Modifier.padding(16.dp))
////                            TextButton(
////                                onClick = {
////                                    navController.navigate(Screens.OneHour.route)
////                                    //OneHourCard(navController)
////                                },
////                                modifier = Modifier.align(Alignment.CenterVertically)
////                            ) {
////                                Text(
////                                    text = "Plan Details",
////                                    color = Color.Blue,
////                                    fontWeight = FontWeight.Bold,
////                                    textDecoration = TextDecoration.Underline
////                                )
////                            }
////                            Spacer(modifier = Modifier.padding(18.dp))
//////                    TextButton(
//////                        onClick = { showCard2 = true },
//////                        modifier = Modifier.align(Alignment.CenterVertically)
//////                    ) {
//////                        Text(
//////                            text = "Details",
//////                            color = Color.Blue,
//////                            textDecoration = TextDecoration.Underline
//////                        )
//////                    }
//////                    Spacer(modifier = Modifier.padding(16.dp))
//////                }
//////            }
////
////                            Spacer(modifier = Modifier.padding(16.dp))
////
////                            Card(colors = CardDefaults.cardColors(containerColor = Color(0xFFA5D6A7))) {
////                                Row {
////                                    Text(
////                                        text = "10 Hours",
////                                        fontWeight = FontWeight.Bold,
////                                        fontSize = 20.sp,
////                                        modifier = Modifier.padding(30.dp)
////                                    )
////                                    Spacer(modifier = Modifier.padding(11.dp))
//////                    TextButton(
//////                        onClick = { navController.navigate(Screens.Payment.route) },
//////                        modifier = Modifier.align(Alignment.CenterVertically)
//////                    ) {
//////                        Text(
//////                            text = "Book Now",
//////                            color = Color.Blue,
//////                            fontWeight = FontWeight.Bold,
//////                            textDecoration = TextDecoration.Underline
//////                        )
//////                    }
////                                    Spacer(modifier = Modifier.padding(18.dp))
////                                    TextButton(
////                                        onClick = { showCard3 = true },
////                                        modifier = Modifier.align(Alignment.CenterVertically)
////                                    ) {
////                                        Text(
////                                            text = "Details",
////                                            color = Color.Blue,
////                                            textDecoration = TextDecoration.Underline
////                                        )
////                                    }
////                                    Spacer(modifier = Modifier.padding(16.dp))
////                                }
////                            }
////                        }
////                    }
////                    if (showCard) {
////                        Dialog(
////                            onDismissRequest = { showCard = false }
////                        ) {
////                            // Surface so the dialog content can fill the screen
////                            Surface(
////                                modifier = Modifier
////                                    .width(300.dp)           // or .fillMaxWidth(0.9f)
////                                    .wrapContentHeight()     // only as tall as your card needs
////                                    .padding(16.dp),
////                                tonalElevation = 8.dp,
////                                shape = RoundedCornerShape(12.dp)
////                            ) {
////                                // but tapping outside or pressing register closes registration form
////                                OneHourCard(navController = navController)
////                            }
////                        }
////                    }
////                    if (showCard2) {
////                        Dialog(
////                            onDismissRequest = { showCard2 = false }
////                        ) {
////                            // Surface so the dialog content can fill the screen
////                            Surface(
////                                modifier = Modifier
////                                    .width(300.dp)           // or .fillMaxWidth(0.9f)
////                                    .wrapContentHeight()     // only as tall as your card needs
////                                    .padding(16.dp),
////                                tonalElevation = 8.dp,
////                                shape = RoundedCornerShape(12.dp)
////                            ) {
////                                // but tapping outside or pressing register closes registration form
////                                FiveHourCard(navController = navController)
////                            }
////                        }
////                    }
////                    if (showCard3) {
////                        Dialog(
////                            onDismissRequest = { showCard3 = false }
////                        ) {
////                            // Surface so the dialog content can fill the screen
////                            Surface(
////                                modifier = Modifier
////                                    .width(300.dp)           // or .fillMaxWidth(0.9f)
////                                    .wrapContentHeight()     // only as tall as your card needs
////                                    .padding(16.dp),
////                                tonalElevation = 8.dp,
////                                shape = RoundedCornerShape(12.dp)
////                            ) {
////                                // but tapping outside or pressing register closes registration form
////                                TenHourCard(navController = navController)
////                            }
////                        }
////                    }
////                }
//            }
//        }
//    }
//}
//    }
//
//@Composable
//fun SimpleTable() {
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(16.dp)
//    ) {
//        // Table Header
//        Row(modifier = Modifier.fillMaxWidth()) {
//            TableCell("Name", weight = 1f, bold = true)
//            TableCell("Age", weight = 1f, bold = true)
//            TableCell("City", weight = 1f, bold = true)
//        }
//
//        // Table Rows
//        Row(modifier = Modifier.fillMaxWidth()) {
//            TableCell("Alice", weight = 1f)
//            TableCell("25", weight = 1f)
//            TableCell("New York", weight = 1f)
//        }
//        Row(modifier = Modifier.fillMaxWidth()) {
//            TableCell("Bob", weight = 1f)
//            TableCell("30", weight = 1f)
//            TableCell("Los Angeles", weight = 1f)
//        }
//    }
//}
//
//@Composable
//fun TableCell(
//    text: String,
//    weight: Float,
//    bold: Boolean = false
//) {
//    Text(
//        text = text,
//        modifier = Modifier
//            .padding(8.dp),
//        fontWeight =FontWeight.Normal
//        //fontWeight = if (bold) FontWeight.Bold else FontWeight.Normal
//    )
//}
