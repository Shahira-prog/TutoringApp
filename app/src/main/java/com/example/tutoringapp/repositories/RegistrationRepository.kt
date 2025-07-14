package com.example.tutoringapp.repositories

import com.example.tutoringapp.dataclasses.RegistrationEntity
import com.example.tutoringapp.room.RegistrationDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

// helper library that uses dao to communicate with database
class RegistrationRepository @Inject constructor (private val dao: RegistrationDao) {
    // saves registration to database by asking dao to insert
    suspend fun add(reg: RegistrationEntity) = dao.insert(reg)
    // gets all registrations from database by asking dao to get all
    val allRegs: Flow<List<RegistrationEntity>> = dao.getAllRegistrations()
}