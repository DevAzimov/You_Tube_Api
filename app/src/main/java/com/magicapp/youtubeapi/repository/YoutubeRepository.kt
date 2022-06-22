package com.magicapp.youtubeapi.repository

import com.magicapp.youtubeapi.network.service.ApiService

class YoutubeRepository(val apiService: ApiService) {

    suspend fun getData() = apiService.getData()
}