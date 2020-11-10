package com.anton.dobrogorsky.familybudget.app.koin.modules

import android.app.Application
import androidx.room.Room
import com.anton.dobrogorsky.familybudget.app.AppDataBase
import com.anton.dobrogorsky.familybudget.flow.records.RecordsViewModel
import com.anton.dobrogorsky.familybudget.flow.report.ReportViewModel
import com.anton.dobrogorsky.familybudget.flow.settings.SettingsViewModel
import com.anton.dobrogorsky.familybudget.model.dao.PersonalDao
import com.anton.dobrogorsky.familybudget.repository.PersonalRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

object Modules {
    val viewModelModule = module {
        viewModel { SettingsViewModel(userRepository = get()) }
        viewModel { ReportViewModel() }
        viewModel { RecordsViewModel() }
    }

    val repositoryModule = module {
        single { PersonalRepository(get())}
    }

    val databaseModule = module {
        fun provideDatabase(application: Application): AppDataBase {
            return Room.databaseBuilder(application, AppDataBase::class.java, "db_family_budget")
                .fallbackToDestructiveMigration()
                .build()
        }

        fun providePersonalDao(database: AppDataBase): PersonalDao {
            return database.personalDao
        }

        single { provideDatabase(androidApplication()) }
        single { providePersonalDao(get()) }
    }
}