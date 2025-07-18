package com.shahira.myuacademy.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shahira.myuacademy.dataclasses.Review
import com.shahira.myuacademy.repositories.ReviewRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReviewViewModel @Inject constructor(
    private val repository: ReviewRepository
) : ViewModel() {
    val allReviews: Flow<List<Review>> = repository.allReviews
    fun insert(review: Review) = viewModelScope.launch {
        repository.insertReview(review)
    }
    fun update(review: Review) = viewModelScope.launch {
        repository.updateReview(review)
    }
}