package com.anton.dobrogorsky.familybudget.app.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.anton.dobrogorsky.familybudget.model.TransactionType
import com.anton.dobrogorsky.familybudget.model.dao.MoneyTransactionDao
import com.anton.dobrogorsky.familybudget.model.entity.Personal
import com.anton.dobrogorsky.familybudget.model.dao.PersonalDao
import com.anton.dobrogorsky.familybudget.model.entity.MoneyTransaction

@Database(entities = [Personal::class, MoneyTransaction::class], version = 2)
@TypeConverters(TransactionType.Converter::class)
abstract class AppDataBase: RoomDatabase() {

    abstract val personalDao: PersonalDao

    abstract val moneyTransactionDao: MoneyTransactionDao

}