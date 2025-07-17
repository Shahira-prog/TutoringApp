package com.shahira.myuacademy.dataclasses

import androidx.room.Entity
import androidx.room.PrimaryKey

// creates table named "registrations" in database
@Entity(tableName = "registrations")
data class RegistrationEntity(
    // key lets the computer know that each row is unique
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val firstName: String,
    val lastName: String,
    val email: String,
    val phone: Int,
    val dob: Int,
    val gradeLevel: Int,
    val accepted: Boolean

)