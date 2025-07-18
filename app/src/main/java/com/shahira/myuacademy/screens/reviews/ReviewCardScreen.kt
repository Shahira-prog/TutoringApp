package com.shahira.myuacademy.screens.reviews

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.shahira.myuacademy.dataclasses.Review
import com.shahira.myuacademy.viewmodels.ReviewViewModel

@Composable
fun ReviewCardScreen(initial: Review? = null,
                     onSubmit: (Review) -> Unit,
                     onCancel: () -> Unit,
                     viewModel: ReviewViewModel = hiltViewModel()) {

    // seed state from `initial` if editing, or blank if adding
    var name by remember { mutableStateOf(initial?.name ?: "") }
    var location by remember { mutableStateOf(initial?.location ?: "") }
    var review by remember { mutableStateOf(initial?.review ?: "") }
    var source by remember { mutableStateOf(initial?.source ?: "") }

    Column(modifier = Modifier.padding(26.dp)) {
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = location,
            onValueChange = { location = it },
            label = { Text("Location") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = review,
            onValueChange = { review = it },
            label = { Text("Review") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = source,
            onValueChange = { source = it },
            label = { Text("Source") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        // 2) Submit / Cancel row
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(
                onClick = {
                    val out = Review(
                        id = initial?.id ?: 0,
                        name = name,
                        location = location,
                        review = review,
                        source = source,
                        date = System.currentTimeMillis(),
                        placeholderone = "",
                        placeholdertwo = ""
                    )
                    onSubmit(out)   // hand back to parent screen for insert or update
                },
                modifier = Modifier.weight(1f)
            ) {
                Text(if (initial == null) "Add" else "Update")
            }
            Button(
                onClick = onCancel,  // parent will hide this form
                modifier = Modifier.weight(1f)
            ) {
                Text("Cancel")
            }
        }
    }
}
