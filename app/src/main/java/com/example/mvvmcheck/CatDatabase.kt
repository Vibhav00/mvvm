package com.example.mvvmcheck

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table1")
data class CatDatabase(
    @PrimaryKey(autoGenerate = true)
    val idt:Int,
    val height: Int,
    val id: String,
    val url: String,
    val width: Int
)