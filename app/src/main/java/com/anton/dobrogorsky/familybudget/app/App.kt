package com.anton.dobrogorsky.familybudget.app

import android.app.Application
import androidx.room.Room
import com.anton.dobrogorsky.familybudget.app.koin.modules.Modules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            koin.loadModules(listOf(
                Modules.databaseModule,
                Modules.repositoryModule,
                Modules.viewModelModule,))
            koin.createRootScope()
        }

    }

}