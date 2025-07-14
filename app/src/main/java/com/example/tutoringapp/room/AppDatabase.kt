package com.example.tutoringapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tutoringapp.dataclasses.RegistrationEntity

// creates database with registrations table inside
@Database(entities = [RegistrationEntity::class], version = 4)
abstract class AppDatabase : RoomDatabase() {
    // connects database to dao (to communicate with database)
    abstract fun registrationDao(): RegistrationDao

    companion object {
        // keeps one instance of the database so we don't create multiple each time
        @Volatile private var INSTANCE: AppDatabase? = null
        // if database doesn't exist, create it...if it exists, return it
        fun getInstance(ctx: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    ctx.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build().also { INSTANCE = it }
            }
    }
}