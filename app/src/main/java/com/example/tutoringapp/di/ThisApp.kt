package com.example.tutoringapp.di

import android.app.Application
import com.google.firebase.FirebaseApp
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ThisApp: Application() {

    override fun onCreate() {
        super.onCreate()
        //initialize firebase
        FirebaseApp.initializeApp(this)
    }
}