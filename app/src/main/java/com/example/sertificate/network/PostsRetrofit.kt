package com.example.sertificate.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PostsRetrofit {

    private val retrofit : Retrofit = Retrofit.Builder()
        .baseUrl("https://plain-cod-wetsuit.cyclic.app")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val postsService: PostsService = retrofit.create(PostsService::class.java)

}