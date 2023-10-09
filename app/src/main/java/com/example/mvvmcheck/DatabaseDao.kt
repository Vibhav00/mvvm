package com.example.mvvmcheck

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface DatabaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(catDatabase: CatDatabase): Long

    @Query("select * from table1")
    fun getAllItems(): LiveData<List<CatDatabase>>

}