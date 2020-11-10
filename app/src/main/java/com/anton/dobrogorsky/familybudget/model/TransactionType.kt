package com.anton.dobrogorsky.familybudget.model

import androidx.room.TypeConverter

enum class TransactionType {
    INCOME, CONSUMPTION;

    object Converter {
        @TypeConverter
        @JvmStatic
        fun toInt(userType: TransactionType): Int = userType.ordinal

        @TypeConverter
        @JvmStatic
        fun fromInt(int: Int): TransactionType = values()[int]
    }
}