package com.anton.dobrogorsky.familybudget.app.koin.modules

import android.app.Application
import androidx.room.Room
import com.anton.dobrogorsky.familybudget.app.database.AppDataBase
import com.anton.dobrogorsky.familybudget.app.database.MIGRATION_1_2
import com.anton.dobrogorsky.familybudget.flow.records.RecordsViewModel
import com.anton.dobrogorsky.familybudget.flow.report.ReportViewModel
import com.anton.dobrogorsky.familybudget.flow.settings.SettingsViewModel
import com.anton.dobrogorsky.familybudget.model.dao.MoneyTransactionDao
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
        single { PersonalRepository(get()) }
    }

    val databaseModule = module {
        fun provideDatabase(application: Application): AppDataBase {
            return Room.databaseBuilder(application, AppDataBase::class.java, "db_family_budget")
                .fallbackToDestructiveMigration()
                .addMigrations(MIGRATION_1_2)
                .build()
        }

        fun providePersonalDao(database: AppDataBase): PersonalDao {
            return database.personalDao
        }

        fun provideMoneyTransactionDao(dataBase: AppDataBase): MoneyTransactionDao {
            return dataBase.moneyTransactionDao
        }

        single { provideDatabase(androidApplication()) }
        single { providePersonalDao(get()) }
        single { provideMoneyTransactionDao(get()) }
    }
}