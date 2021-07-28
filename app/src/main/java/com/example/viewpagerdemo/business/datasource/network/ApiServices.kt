package com.example.viewpagerdemo.business.datasource.network

import com.example.viewpagerdemo.business.datasource.network.videoresponses.VideoNetworkEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {
    @GET("search")
    suspend fun getVideoList(@Query("term")term: String,@Query("media")media: String): VideoNetworkEntity
}