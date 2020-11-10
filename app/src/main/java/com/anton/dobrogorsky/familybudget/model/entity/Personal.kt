package com.anton.dobrogorsky.familybudget.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Personal(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val name: String,
    val surname: String)