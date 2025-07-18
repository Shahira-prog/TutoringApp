package com.shahira.myuacademy.repositories

import com.shahira.myuacademy.dataclasses.Review
import com.shahira.myuacademy.room.ReviewDAO
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ReviewRepository @Inject constructor(private val reviewDao: ReviewDAO) {
    suspend fun insertReview(review: Review) {
        reviewDao.insertReview(review)
    }
    suspend fun updateReview(review: Review) {
        reviewDao.updateReview(review)
    }
    val allReviews: Flow<List<Review>> = reviewDao.getAllReviews()
}