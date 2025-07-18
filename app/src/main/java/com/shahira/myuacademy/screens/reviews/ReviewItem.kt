package com.shahira.myuacademy.screens.reviews

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.shahira.myuacademy.dataclasses.Review

@Composable
fun ReviewItem(review: Review, isSelected: Boolean, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .widthIn(max = 360.dp)
            .heightIn(max = 200.dp)
            .wrapContentWidth(Alignment.CenterHorizontally)
            .padding(vertical = 4.dp, horizontal = 8.dp)
            .verticalScroll(rememberScrollState())
            .clickable { onClick() },
        // optionally highlight if selected
        colors = if (isSelected)
            CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)
            )
        else
            CardDefaults.cardColors()
    ) {
        Column(Modifier.padding(16.dp)) {
            Text(review.name, style = MaterialTheme.typography.titleMedium)
            Text(review.location, style = MaterialTheme.typography.titleSmall)
            Text(review.review, style = MaterialTheme.typography.bodyMedium)
            Text(review.source, style = MaterialTheme.typography.bodySmall.copy(color = Color.Blue))
        }
    }
}