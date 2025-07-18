package com.shahira.myuacademy.dataclasses

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "reviews")
data class Review(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val location: String,
    val review: String,
    val source: String,
    val date: Long,
    val placeholderone: String,
    val placeholdertwo: String
    )
