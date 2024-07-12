package com.example.android3homework2mc5.ui.fragments

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.android3homework2mc5.models.PhotosResponse
import com.example.android3homework2mc5.utils.parseJsonToModel
import com.example.android3homework2mc5.utils.readJsonFromAssets

class HomeViewModel(private val application: Application) : AndroidViewModel(application) {

    fun getPhotos(): PhotosResponse {
        val photosJsonString = application.applicationContext.readJsonFromAssets("photos.json")
        val response = parseJsonToModel<PhotosResponse>(photosJsonString)
        return response
    }

    //это он крей начала создание
    override fun onCleared() {
        super.onCleared()
    }
}