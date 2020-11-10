package com.anton.dobrogorsky.familybudget.app

import androidx.room.Database
import androidx.room.RoomDatabase
import com.anton.dobrogorsky.familybudget.model.entity.Personal
import com.anton.dobrogorsky.familybudget.model.dao.PersonalDao

@Database(entities = [Personal::class], version = 1)
abstract class AppDataBase: RoomDatabase() {

    abstract val personalDao: PersonalDao

}