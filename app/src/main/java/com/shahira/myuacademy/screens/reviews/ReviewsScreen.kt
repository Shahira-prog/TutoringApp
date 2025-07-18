package com.shahira.myuacademy.screens.reviews

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.shahira.myuacademy.dataclasses.Review
import com.shahira.myuacademy.viewmodels.ReviewViewModel

@Composable
fun ReviewsScreen(navController: NavController, reviewViewModel: ReviewViewModel, innerPadding: PaddingValues)
{
    var showForm       by remember { mutableStateOf(false) }
    var editingReview by remember { mutableStateOf<Review?>(null) }
    val reviews by reviewViewModel.allReviews.collectAsState(initial = emptyList())

    Spacer(modifier = Modifier.height(27.dp))
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(16.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            items(reviews) { r ->
                ReviewItem(
                    review     = r,
                    isSelected = r.id == editingReview?.id,
                    onClick    = { editingReview = r }
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Button(
                onClick = {
                    editingReview = null
                    showForm      = true
                },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFA5D6A7),
                    contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            ) { Text("Insert Review") }

            Button(
                onClick = {
                    if (editingReview != null) showForm = true
                },
                enabled = editingReview != null,
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFA5D6A7),
                    contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            ) { Text("Update Review") }
        }
    }
        // 3) dialog for add or edit
        if (showForm) {
            Dialog(onDismissRequest = { showForm = false }) {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    tonalElevation = 4.dp,
                    shape = RoundedCornerShape(8.dp)
                ) {
                    LazyColumn(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        item {
                            ReviewCardScreen(
                                initial = editingReview,
                                onSubmit = { out ->
                                    if (editingReview == null) {
                                        reviewViewModel.insert(out)
                                    } else {
                                        reviewViewModel.update(out)
                                    }
                                    showForm = false
                                    editingReview = null
                                },
                                onCancel = {
                                    showForm = false
                                }
                            )
                        }
                    }
                }
            }
        }
    }