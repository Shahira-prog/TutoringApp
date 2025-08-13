package com.shahira.myuacademy.screens.crashcourses
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.shahira.myuacademy.navigation.Screens
import com.shahira.myuacademy.repositories.CourseRepository

@Composable
fun CrashCoursesScreen(navController: NavController) {
    val courseList = CourseRepository.allCourses

    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        item {
            Text(
                text = "MyU Academy 2025 Fall Courses\n Sep. 25-Dec. 25",
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
        itemsIndexed(courseList) { idx, course ->
            MyCustomItem(
                i = course,
                onDetailsClick = {
                    navController.navigate("${Screens.CourseDetails.route}/$idx")
                }
            )
        }

    }
}

@Composable
fun MyCustomItem(i: Course, onDetailsClick: () -> Unit) {
   // val context = LocalContext.current
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(10.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        ) {
            Row {

                Image(
                    painter = painterResource(id = i.icon),
                    contentDescription = "team pic",
                    modifier = Modifier
                        .height(150.dp)
                        .width(100.dp)
                        .padding(start = 10.dp, end = 5.dp)
                )

                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)) {
                    Text(
                        text = i.title,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                        //modifier = Modifier.background(Color.Green)
                    )

                    Spacer(modifier = Modifier.height(7.dp))
                    Text(
                        text = "Course Price: " + i.price,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                        //modifier = Modifier.background(Color.Green)
                    )

                    Spacer(modifier = Modifier.height(7.dp))
                    Text(
                        text = "Course Status: " + i.status,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                        //modifier = Modifier.background(Color.Green)
                    )

                    Spacer(modifier = Modifier.height(7.dp))
                    Text(
                        text = "Course Length: " + i.length,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                        //modifier = Modifier.background(Color.Green)
                    )

                    Spacer(Modifier.height(7.dp))
                    Text(
                        "More Details",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Blue,
                        modifier = Modifier.clickable {
                            onDetailsClick()
                        }
                    )
                }
            }
            Spacer(modifier = Modifier.height(7.dp))
            Text(
                text = i.description.substring(0, 150),
                fontSize = 15.sp,
                modifier = Modifier.padding(bottom = 10.dp)
            )


        }
    }
}


data class Course(
    val title: String,
    val icon: Int,
    val price: String,
    val description: String,
    val details: () -> Unit,
    val status: String,
    val length: String,
    val location: String,
    val daystimes: String,
    val meetingdates: String

)

//
//Course Information o Instructor Information
//o Credits: 3
//o Course No: 37969
//o Days & Times: MoWe 6:00pm-7:45pm
//o Location: ZOOM
//o Meeting Dates: 5/19/2025-8/11/2025
//o Course ID:







//Toast.makeText(
//                                context,
//                                "Opening details for ${i.title}",
//                                Toast.LENGTH_SHORT
//                            ).show()