package com.shahira.myuacademy.screens.crashcourses
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CourseDetailsScreen(course: Course) {
Card (modifier = Modifier.padding(15.dp)) {

    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())) {
        Text(
            text = course.title,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 40.dp).fillMaxWidth(),
            textAlign= TextAlign.Center
        )
        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Meeting Dates: "+"${course.meetingdates}",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 10.dp)
        )

       Spacer(modifier = Modifier.height(5.dp))


        Text(
            text = "Days Times: "+"${course.daystimes} ",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 10.dp)
        )


        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = "Total of: "+"${course.length} ",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 10.dp)
        )

        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = "Location: "+"${course.location} ",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 10.dp)
        )

        Spacer(modifier = Modifier.height(15.dp))

        Text(
            text = course.description,
            fontSize = 15.sp,
            fontWeight = FontWeight.Normal,
           modifier = Modifier.padding(start = 10.dp, top = 10.dp, end = 10.dp, bottom = 50.dp)
        )
    }

}

}