package com.anton.dobrogorsky.familybudget.app.database

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_1_2 = object: Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("CREATE TABLE IF NOT EXISTS `money_transaction` " +
                "(`id` INTEGER, " +
                "`value` FLOAT, " +
                "`transaction_type` INTEGER," +
                "PRIMARY KEY(`id`))")
    }

}