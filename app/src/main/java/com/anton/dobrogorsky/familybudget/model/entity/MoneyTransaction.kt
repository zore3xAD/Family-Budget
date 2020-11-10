package com.anton.dobrogorsky.familybudget.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.anton.dobrogorsky.familybudget.model.TransactionType

@Entity(tableName = MoneyTransaction.TABLE_NAME)
data class MoneyTransaction(
    @ColumnInfo(name = COLUMN_ID)
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @ColumnInfo(name = COLUMN_VALUE)
    val value: Double,
    @ColumnInfo(name = COLUMN_TRANSACTION_TYPE)
    @TypeConverters(TransactionType.Converter::class)
    val type: TransactionType = TransactionType.CONSUMPTION
) {
    companion object {
        const val TABLE_NAME = "money_transaction"
        const val COLUMN_ID = "id"
        const val COLUMN_VALUE = "value"
        const val COLUMN_TRANSACTION_TYPE = "transaction_type"
    }
}
