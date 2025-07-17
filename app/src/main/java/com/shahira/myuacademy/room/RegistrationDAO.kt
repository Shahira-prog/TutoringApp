package com.shahira.myuacademy.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.shahira.myuacademy.dataclasses.RegistrationEntity
import kotlinx.coroutines.flow.Flow

// data access object, dao acts as doorway to get data to and from database
@Dao
interface RegistrationDao {
    // insert instructs computer to add a new registration to the database
    @Insert
    suspend fun insert(reg: RegistrationEntity)
    // query is used to retrieve data from the database
    @Query("SELECT * FROM registrations")
    fun getAllRegistrations(): Flow<List<RegistrationEntity>>
}