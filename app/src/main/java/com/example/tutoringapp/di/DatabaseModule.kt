package com.example.tutoringapp.di

import android.content.Context
import androidx.room.Room
import com.example.tutoringapp.room.AppDatabase
import com.example.tutoringapp.room.RegistrationDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext ctx: Context): AppDatabase =
        Room.databaseBuilder(
            ctx,
            AppDatabase::class.java,
            "app_database"
        ).build()

    @Provides
    fun provideRegistrationDao(db: AppDatabase): RegistrationDao =
        db.registrationDao()
}