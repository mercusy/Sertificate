package com.example.sertificate.network

import com.example.sertificate.dto.PostsList
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface PostsService {
    @GET("posts")
    fun getPost() : Call<PostsList>

    @POST("posts")
    fun setPost(@Body() title: String) : Call<PostsList>
}