package com.example.tutoringapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tutoringapp.dataclasses.RegistrationEntity
import com.example.tutoringapp.repositories.RegistrationRepository
import com.example.tutoringapp.room.AppDatabase
import com.example.tutoringapp.room.RegistrationDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

// viewmodel is the brain that talks to the repository and handles data
@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val repo: RegistrationRepository
): ViewModel() {
    fun saveRegistration(reg: RegistrationEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.add(reg)
        }
    }
    fun getAllRegistrations(): Flow<List<RegistrationEntity>> = repo.allRegs

//    live data that gets all registrations from repository
//    val allRegs: Flow<List<RegistrationEntity>> = repo.allRegs
}
