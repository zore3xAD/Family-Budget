package com.anton.dobrogorsky.familybudget.model.dao

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.anton.dobrogorsky.familybudget.model.TransactionType
import com.anton.dobrogorsky.familybudget.model.entity.MoneyTransaction

@Dao
interface MoneyTransactionDao {

    @Insert
    suspend fun insertMoneyTransaction(moneyTransaction: MoneyTransaction)

    @Query("SELECT * FROM ${MoneyTransaction.TABLE_NAME}")
    fun getAllMoneyTransactions(): LiveData<List<MoneyTransaction>>

    fun getAllConsumptionTransactions(): LiveData<List<MoneyTransaction>> = getTransactionsByType(TransactionType.CONSUMPTION)

    fun getAllIncomeTransactions(): LiveData<List<MoneyTransaction>> = getTransactionsByType(TransactionType.INCOME)

    @Query("SELECT * FROM ${MoneyTransaction.TABLE_NAME} WHERE ${MoneyTransaction.COLUMN_TRANSACTION_TYPE} = :type")
    fun getTransactionsByType(type: TransactionType): LiveData<List<MoneyTransaction>>
}