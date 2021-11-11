package com.example.almin.Retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Query

interface APIInterface {
    @GET(" /search/shows")
    fun search(@Query("q")q:String):Call<Data?>?
}

