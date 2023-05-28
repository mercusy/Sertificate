package com.example.sertificate.viewModel

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.sertificate.dto.GetPost
import com.example.sertificate.dto.ListPosts
import com.example.sertificate.dto.Post
import com.example.sertificate.network.PostsRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

sealed interface PostsState{

    object Loading : PostsState
    class Error(val message: String) : PostsState
    class Success(val posts: ArrayList<Post>) : PostsState
}

class PostsViewModel(application: Application) : AndroidViewModel(application) {

    val liveData = MutableLiveData<PostsState>(PostsState.Loading)

    private val postsService = PostsRetrofit.postsService

    fun load(){
        postsService.getPost()
            .enqueue(object: Callback<GetPost> {
                override fun onResponse(call: Call<GetPost>, response: Response<GetPost>) {
                    if (response.isSuccessful) {
                        val allPosts = response.body()
                        liveData.value = PostsState.Success(allPosts?.post?: arrayListOf())
                    }
                    else {
                        liveData.value = PostsState.Error(response.message())
                    }
                }

                override fun onFailure(call: Call<GetPost>, t: Throwable) {
                    liveData.value = PostsState.Error(t.message ?: "Error on request")
                }

            })
    }

}