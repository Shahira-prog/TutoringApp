package com.example.tutoringapp.screens.home

import android.widget.ImageView
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.tutoringapp.R

@Composable
fun PhotoGallery(
    modifier: Modifier = Modifier,
    autoScroll: Boolean = true,
    slideIntervalMs: Long = 30L
) {
    // 12 photos im using
    val photos = listOf(
        R.drawable.photo1,
        R.drawable.photo2,
        R.drawable.photo3,
        R.drawable.photo4,
        R.drawable.photo5,
        R.drawable.photo6,
        R.drawable.photo7,
        R.drawable.photo8,
        R.drawable.photo9,
        R.drawable.photo10,
        R.drawable.photo11,
        R.drawable.photo12
    )
    // the pager state
    val pagerState = rememberPagerState { photos.size }

    // auto slide show
    if (autoScroll && photos.size > 1) {
        LaunchedEffect(pagerState) {
            while (true) {
                kotlinx.coroutines.delay(slideIntervalMs)
                val next = (pagerState.currentPage + 1) % pagerState.pageCount
                pagerState.animateScrollToPage(next)
            }
        }
    }

    Column(modifier = modifier.fillMaxWidth()) {
        // the pager
        HorizontalPager(
            state    = pagerState,
            modifier = modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        ) { page ->
            Image(
                painter            = painterResource(photos[page]),
                contentDescription = null,
                modifier           = Modifier
                    .fillMaxSize()
                    .aspectRatio(1.0f)  // square content inside the fixed-width page
            )
        }
    }
}