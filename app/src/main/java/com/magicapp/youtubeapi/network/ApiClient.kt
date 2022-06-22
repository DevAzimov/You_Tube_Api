package com.magicapp.youtubeapi.network

import com.magicapp.youtubeapi.network.service.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    const val BASE_URL = "https://www.googleapis.com/youtube/v3/"
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    val apiService = getRetrofit().create(ApiService::class.java)
}