package com.example.mvvmcheck

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CatDatabase::class], version = 1)
abstract class DatabaseMain : RoomDatabase() {


    abstract fun getDatabaseDaw(): DatabaseDao

    companion object {
        @Volatile
        private var instance: DatabaseMain? = null

        private var LOCK = Any()
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also {
                instance = it
            }
        }


        private fun createDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            DatabaseMain::class.java,
            "database_main.db"
        )
            .build()
    }


}