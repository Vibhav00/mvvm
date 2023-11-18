package com.example.mvvmcheck

import android.util.Log
import retrofit2.Response

class CatRepository(val db: DatabaseMain) {
    /**
     *  get all cats from api
     **/
    suspend fun getAllCats(limit: Int): Response<List<Cat>> {
        val k = RetrofitInstance.api.getCats(limit)
        return k;
    }

    /**
     *  insert and update cats into room database
     **/
    suspend fun upsert(catDatabase: CatDatabase) = db.getDatabaseDaw().upsert(catDatabase)

    /**
     *  get all cats from  local database
     **/
    fun getAllCats() = db.getDatabaseDaw().getAllItems()
}