package com.anton.dobrogorsky.familybudget.model.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.anton.dobrogorsky.familybudget.model.entity.Personal

@Dao
interface PersonalDao {

    @Insert suspend fun insert(personal: Personal)

    @Update suspend fun update(personal: Personal)

    @Delete fun delete(personal: Personal)

    @Query("SELECT * FROM personal") fun get(): LiveData<Personal>

}