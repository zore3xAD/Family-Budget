package com.anton.dobrogorsky.familybudget.app

import android.app.Application
import androidx.room.Room

class App : Application() {
 companion object {
     lateinit var appDatabase: AppDataBase
 }

    override fun onCreate() {
        super.onCreate()

        appDatabase =
            Room.databaseBuilder(this, AppDataBase::class.java, "db_family_budget").build()
    }

}