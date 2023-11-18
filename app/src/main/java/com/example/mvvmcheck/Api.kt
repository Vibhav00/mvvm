package com.example.mvvmcheck

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("search")
    suspend fun getCats(
        @Query("limit")
        limit: Int = 10
    ): Response<List<Cat>>
}