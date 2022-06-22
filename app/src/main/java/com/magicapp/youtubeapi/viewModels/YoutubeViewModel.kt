package com.magicapp.youtubeapi.viewModels

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.magicapp.youtubeapi.models.YoutubeApiData
import com.magicapp.youtubeapi.network.ApiClient
import com.magicapp.youtubeapi.repository.YoutubeRepository
import com.magicapp.youtubeapi.utils.NetworkHelper
import com.magicapp.youtubeapi.utils.Resource
import kotlinx.coroutines.launch

class YoutubeViewModel : ViewModel() {

    private val youtubeRepository = YoutubeRepository(ApiClient.apiService)
    private val liveData = MutableLiveData<Resource<YoutubeApiData>>()

    fun getYoutubeData(context: Context): LiveData<Resource<YoutubeApiData>> {
        val networkHelper = NetworkHelper(context)
        if (networkHelper.isNetworkConnected()) {
            viewModelScope.launch {
                liveData.postValue(Resource.loading(null))
                val responce = youtubeRepository.getData()
                if (responce.isSuccessful) {
                    liveData.postValue(Resource.success(responce.body()))
                } else {
                    liveData.postValue(
                        Resource.error(
                            responce.errorBody()?.string().toString(),
                            null
                        )
                    )
                }
            }
        } else {
            liveData.postValue(Resource.error("Internet not connection", null))
        }
        return liveData
    }
}