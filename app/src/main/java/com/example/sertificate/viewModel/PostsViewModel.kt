package com.example.sertificate.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.sertificate.dto.PostsList
import com.example.sertificate.network.PostsRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

sealed interface PostsState{

    object Loading : PostsState
    class Error(message: String) : PostsState
    class Success(post: PostsList) : PostsState
}

class PostsViewModel(application: Application) : AndroidViewModel(application) {

    val liveData = MutableLiveData<PostsState>(PostsState.Loading)

    private val postsService = PostsRetrofit.postsService

    fun load(){
        postsService.getPost()
            .enqueue(object: Callback<PostsList> {
                override fun onResponse(call: Call<PostsList>, response: Response<PostsList>) {
                    if (response.isSuccessful) {
                        val allPosts = response.body()!!
                        liveData.value = PostsState.Success(allPosts)
                    }
                    else {
                        liveData.value = PostsState.Error(response.message())
                    }
                }

                override fun onFailure(call: Call<PostsList>, t: Throwable) {
                    liveData.value = PostsState.Error(t.message ?: "Error on request")
                }

            })
    }

}