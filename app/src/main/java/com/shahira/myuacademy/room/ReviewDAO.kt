package com.shahira.myuacademy.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.shahira.myuacademy.dataclasses.Review
import kotlinx.coroutines.flow.Flow

@Dao
interface ReviewDAO {
    @Insert
    suspend fun insertReview(review: Review)
    @Query("SELECT * FROM reviews")
    fun getAllReviews(): Flow<List<Review>>
    @Update
    suspend fun updateReview(review: Review)

}