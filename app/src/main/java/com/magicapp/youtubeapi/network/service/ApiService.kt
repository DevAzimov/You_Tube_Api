package com.magicapp.youtubeapi.network.service

import com.magicapp.youtubeapi.models.YoutubeApiData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("search")
    suspend fun getData(
        @Query("key") key: String = "AIzaSyDpRo2A3TbjXDleozHOPPqXiZE89oMXe1M",
        @Query("channelId") channelId: String = "UCFMPyPzKbQ4YxhBbc4x1hhw",
        @Query("part") part: String = "snippet,id",
        @Query("order") order: String = "date",
        @Query("maxResults") maxResults: Int = 20
    ): Response<YoutubeApiData>

}