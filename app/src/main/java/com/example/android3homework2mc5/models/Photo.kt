package com.example.android3homework2mc5.models

import com.google.gson.annotations.SerializedName

data class Photo(
    @SerializedName("id")
    val id : String,
    @SerializedName("secret")
    val secret: String,
    @SerializedName("server")
    val server: String,
    @SerializedName("title")
    val title: String,
    val url: String = "https://farm66.staticflickr.com/$server/${id}_$secret"
)
