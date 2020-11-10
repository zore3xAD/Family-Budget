package com.anton.dobrogorsky.familybudget.repository

import com.anton.dobrogorsky.familybudget.model.entity.Personal
import com.anton.dobrogorsky.familybudget.model.dao.PersonalDao

class PersonalRepository(private val personalDao: PersonalDao) {

    val personalInfo = personalDao.get()

    suspend fun insert(personalInfo: Personal) {
        personalDao.insert(personalInfo)
    }

    suspend fun update(personalInfo: Personal) {
        personalDao.update(personalInfo)
    }

}