package com.shahira.myuacademy.screens.home

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.shahira.myuacademy.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController,
               onAccountClick: () -> Unit,
               onSettingsClick: () -> Unit) {
    // 1) Hoist all your state here
    var showForm by remember { mutableStateOf(false) }               // hidden by default :contentReference[oaicite:0]{index=0}
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf(0) }
    var message by remember { mutableStateOf("") }

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
                    .verticalScroll(scrollState)   // ← makes it scrollable
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Card(colors = CardDefaults.cardColors(containerColor = Color(0xFFA5D6A7)))
                    {
                        PhotoGallery(
                            modifier = Modifier
                                .height(250.dp)
                                .border(
                                    1.dp,
                                    Color(0xFFaed986),
                                    RoundedCornerShape(3)
                                ),   // constrain its size
                            autoScroll = true,
                            slideIntervalMs = 5000L
                        )
                    }

                    Spacer(modifier = Modifier.padding(15.dp))

                    Card(colors = CardDefaults.cardColors(Color.White))
                    {

                        Text(
                            text = "Transforming Students' Confidence & Academic Success — One Lesson at a Time",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(start = 5.dp).fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.padding(10.dp))
                        BoldWordsParagraph()
                    }
                    Spacer(modifier = Modifier.padding(5.dp))
                    Card(colors = CardDefaults.cardColors(Color.White))
                    {
                        Text(
                            text = "Office Address:",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            //modifier = Modifier.padding(start = 1.dp)
                        )

                        Text(
                            text = "6 Pidgeon Hill Dr. Sterling VA 20164\n(Near to the Northern Virginia Community College  Loudoun Campus)",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Normal,
                            //modifier = Modifier.padding(start = 10.dp)
                        )
                        Spacer(modifier = Modifier.padding(5.dp))

                        Text(
                            text = "Call or Text: ",
                            fontSize = 15.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            //modifier = Modifier.padding(start = 10.dp)
                        )

                        Text(
                            text = "703-798-5731",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Normal,
                           // modifier = Modifier.padding(start = 10.dp)
                        )
                        Spacer(modifier = Modifier.padding(5.dp))



                        Image(
                            painter = painterResource(id = R.drawable.sterlingoffice),
                            contentDescription = "Sterling Office",
                            modifier = Modifier
                                .padding(1.dp)
                        )


                    }
                    Spacer(modifier = Modifier.padding(10.dp))
                    Card(colors = CardDefaults.cardColors(Color.White))
                    {
                        Text(
                            text = "Meet Our Team",
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(10.dp)
                                .align(Alignment.CenterHorizontally)
                        )
                        Text(
                            text = "Dr. Atajan",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(start = 5.dp)
                        )
                        Text(
                            text = "Lead Team",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(start = 5.dp)
                        )
                        Text(
                            text = "Dr.  Atajan, a PhD holder in Applied Mathematics, is the founder and lead tutor at MyU Academy. With his extensive expertise and passion for education, he provides personalized tutoring and in depth teaching to help students reach their full academic potential.",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Normal,
                            modifier = Modifier.padding(5.dp)
                        )
                        Text(
                            text = "Nadine Alexander",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(start = 5.dp)
                        )
                        Text(
                            text = "Tutor",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(start = 5.dp)
                        )
                        Text(
                            text = "Nadine Alexander is a part-time tutor at MyUAcademy, currently pursuing a degree in mechanical engineering at the University of Virginia. With a strong foundation in engineering principles, she brings a problem-solving approach to her tutoring, helping students excel in STEM subjects as well as other humanities subjects.",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Normal,
                            modifier = Modifier.padding(5.dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.team),
                            contentDescription = "team pic",
                            modifier = Modifier.padding(10.dp)
                        )

                    }
                }
            }
        }
    }
}

@Composable
fun BoldWordsParagraph() {
    val text = buildAnnotatedString {
        append("Since 2012, MyU Academy has been a trusted partner for families seeking high-quality academic support. We specialize in personalized tutoring for students from elementary school through college, offering expert guidance in Math, English, Science, and more.\n" +
                "\n" +
                "Whether it’s homework help, test prep, or mastering tough concepts, our one-on-one sessions and small group classes (max 5 students) are designed to deliver real results. Every year, 5–10% of MyU students earn admission to elite universities such as Harvard, MIT, and other top-ranked institutions around the world.\n\n" )

        pushStyle(SpanStyle(fontWeight = FontWeight.Bold))
        append("What Sets MyU Academy Apart?")
        pop()
        append("\n\nLed by Dr. Atajan, our team of passionate and experienced instructors is committed to unlocking each student’s full potential. Here’s how we make a difference:\n" +
                "\n" +
                "✅ We build confidence, not just grades – through patient, in-depth explanations and relatable examples.\n\n" +
                "✅ We make learning visual and logical – using diagrams and clear reasoning to simplify difficult topics.\n\n" +
                "✅ We teach smarter, not just harder – sharing memory tricks and practical techniques for applying formulas.\n\n" +
                "✅ We stay one step ahead – by reviewing past material and preparing students for what’s next.\n" +
                "\n" +
                "A Parent’s Testimonial:\n" +
                "“Life-Changing.”\n" +
                "– By: Bryan from Laurel, MD\n" +
                "\n" +
                "“My son used to hate math and struggled for years. After starting tutoring at MyU Academy, everything changed. His grades skyrocketed, and more importantly, he now enjoys learning. Dr. Atajan, explains everything patiently, motivates him, and builds real understanding—not just memorization.\n" +
                "\n" +
                "My son now smiles when we talk about math. I can’t thank MyU Academy enough. Truly life-changing!”\n" +
                "\n" +
                "✨ You can read more reviews by clicking the “Review” tab below!\n" +
                "\n")

        pushStyle(SpanStyle(fontWeight = FontWeight.Bold))
        append( "Ready to give your child the support they deserve?\n\n")
        pop()

        append( "Contact MyU Academy today and take the first step toward academic excellence and lasting confidence., ")

    }

    Text(
        text = text,
        fontSize = 15.sp
    )
}















//
//    Scaffold(
//    ) { innerPadding ->
//        Box(
//            Modifier
//                .fillMaxSize()
//                .padding(innerPadding),
//            contentAlignment = Alignment.TopCenter
//        ) {
//            val scrollState = rememberScrollState()
//            Column(
//                modifier = Modifier
//                    .verticalScroll(scrollState)   // ← makes it scrollable
//            ) {
//                Column(modifier = Modifier.padding(16.dp)) {
//                    Card(colors = CardDefaults.cardColors(containerColor = Color(0xFFA5D6A7)))
//                    {
//                        PhotoGallery(
//                            modifier = Modifier.height(250.dp).border(
//                                1.dp,
//                                Color(0xFFaed986),
//                                RoundedCornerShape(3)
//                            ),   // constrain its size
//                            autoScroll = true,
//                            slideIntervalMs = 5000L
//                        )
//                    }
//
//                    Spacer(modifier = Modifier.padding(15.dp))
//
//                    Card(colors = CardDefaults.cardColors())
//                    {
//                        Text(
//                            text = "One-on-one tutoring that can take place in your home, online, or in person at our tutoring center with an affordable rates which starts from \$30 per hour.  Upon request, for new students, we offer a free 35-minute session before submitting any payment information. Please don't hesitate to reach out us now If you have questions or are interested in our services.",
//                            fontWeight = FontWeight.Normal,
//                            fontSize = 15.sp,
//                            modifier = Modifier.padding(10.dp)
//                        )
//
//                        Text(
//                            text = "Note: ",
//                            fontSize = 15.sp,
//                            color = Color.Black,
//                            fontWeight = FontWeight.Bold,
//                            modifier = Modifier.padding(start = 10.dp)
//                        )
//
//                        Text(
//                            text = "Before purchasing, please contact us for the availability " +
//                                    "and payment options.",
//                            fontSize = 15.sp,
//                            color = Color.Black,
//                            fontWeight = FontWeight.Normal,
//                            modifier = Modifier.padding(start = 10.dp)
//                        )
//
//                    }
//                    Spacer(modifier = Modifier.padding(15.dp))
//                    Card(colors = CardDefaults.cardColors())
//                    {
//                        Text(
//                            text = "Office Address:",
//                            fontSize = 15.sp,
//                            fontWeight = FontWeight.Bold,
//                            modifier = Modifier.padding(start = 10.dp)
//                        )
//
//                        Text(
//                            text = "6 Pidgeon Hill Dr. Sterling VA 20164",
//                            fontSize = 15.sp,
//                            fontWeight = FontWeight.Normal,
//                            modifier = Modifier.padding(start = 10.dp)
//                        )
//
//                        Image(
//                            painter = painterResource(id = R.drawable.sterlingoffice),
//                            contentDescription = "Sterling Office",
//                            modifier = Modifier.padding(1.dp))
//
//                    }
//                    Spacer(modifier = Modifier.padding(15.dp))
//                    Card(colors = CardDefaults.cardColors())
//                    {
//                        Text(
//                            text = "Meet Our Team",
//                            fontSize = 25.sp,
//                            fontWeight = FontWeight.Bold,
//                            modifier = Modifier.padding(10.dp).align(Alignment.CenterHorizontally)
//                        )
//                        Text(
//                            text = "Dr. Talip Atajan",
//                            fontSize = 15.sp,
//                            fontWeight = FontWeight.Bold,
//                            modifier = Modifier.padding(start = 10.dp)
//                        )
//                        Text(
//                            text = "Lead Team",
//                            fontSize = 15.sp,
//                            fontWeight = FontWeight.Bold,
//                            modifier = Modifier.padding(start = 10.dp)
//                        )
//                        Text(
//                            text = "Dr. Talip Atajan, a PhD holder, is the founder and lead tutor at MyU Academy. With his extensive expertise and passion for education, he provides personalized tutoring to help students reach their full academic potential.",
//                            fontSize = 15.sp,
//                            fontWeight = FontWeight.Normal,
//                            modifier = Modifier.padding(10.dp)
//                        )
//                        Text(
//                            text = "Nadine Alexander",
//                            fontSize = 15.sp,
//                            fontWeight = FontWeight.Bold,
//                            modifier = Modifier.padding(start = 10.dp)
//                        )
//                        Text(
//                            text = "Tutor",
//                            fontSize = 15.sp,
//                            fontWeight = FontWeight.Bold,
//                            modifier = Modifier.padding(start = 10.dp)
//                        )
//                        Text(
//                            text = "Nadine Alexander is a part-time tutor at MyUAcademy, currently pursuing a degree in mechanical engineering at the University of Virginia. With a strong foundation in engineering principles, she brings a problem-solving approach to her tutoring, helping students excel in STEM subjects as well as other humanities subjects.",
//                            fontSize = 15.sp,
//                            fontWeight = FontWeight.Normal,
//                            modifier = Modifier.padding(10.dp)
//                        )
//                        Image(
//                            painter = painterResource(id = R.drawable.team),
//                            contentDescription = "team pic",
//                            modifier = Modifier.padding(10.dp))
//
//                    }
//                }
//                if (showForm) {
//                    Dialog(
//                        onDismissRequest = { showForm = false }
//                    ) {
//                        // Surface so the dialog content can fill the screen
//                        Surface(
//                            modifier = Modifier
//                                .height(500.dp)
//                                .padding(16.dp)
//                                .align(Alignment.CenterHorizontally)
//                        ) {showForm = false

                            // 2) Properly pass the hoisted state into ContactUs
//                            AnimatedVisibility(visible = showForm) {
//                                ContactUs(
//                                    modifier = Modifier.padding(top = 16.dp),
//                                    name = name,                           // ← use your state here
//                                    onNameChange = { name = it },
//                                    email = email,
//                                    onEmailChange = { email = it },
//                                    phone = phone,
//                                    onPhoneChange = { phone = it },
//                                    message = message,
//                                    onMessageChange = { message = it },
//                                    onSend = {
//                                        /** add logic here */
//
//                                        showForm = false
//                                    })
//                            }
//                        }
//                    }
//                }
//            }
//        }
   // }
//}