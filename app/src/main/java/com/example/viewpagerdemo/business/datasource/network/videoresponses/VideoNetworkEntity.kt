package com.example.viewpagerdemo.business.datasource.network.videoresponses


import com.google.gson.annotations.SerializedName

data class VideoNetworkEntity(
    @SerializedName("resultCount")
    var resultCount: Int = 0,
    @SerializedName("results")
    var results: List<ResultNetworkEntity> = listOf()
)