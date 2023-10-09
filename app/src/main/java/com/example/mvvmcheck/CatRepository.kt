package com.example.mvvmcheck

import android.util.Log
import retrofit2.Response

class CatRepository(val db:DatabaseMain) {
    suspend fun getAllCats(limit:Int):Response<List<Cat>>{
      val k= RetrofitInstance.api.getCats(limit)
        Log.d("vibhav123",k.toString())
        return k;
    }
    suspend fun upsert(catDatabase: CatDatabase)=db.getDatabaseDaw().upsert(catDatabase)
    fun getAllCats()=db.getDatabaseDaw().getAllItems()
}