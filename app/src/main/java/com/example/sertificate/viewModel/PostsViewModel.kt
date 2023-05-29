package com.example.sertificate.viewModel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.sertificate.dto.GetPost
import com.example.sertificate.dto.Post
import com.example.sertificate.dto.SetPost
import com.example.sertificate.dto.SetPostResponse
import com.example.sertificate.network.PostsRetrofit
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

sealed interface PostsState{

    object Loading : PostsState
    object Done : PostsState
    class Error(val message: String) : PostsState
    class Success(val posts: GetPost) : PostsState
}

class PostsViewModel(application: Application,) : AndroidViewModel(application) {

    val liveData = MutableLiveData<PostsState>(PostsState.Loading)

    private val postsService = PostsRetrofit.postsService

    fun load(){
        viewModelScope.launch(Dispatchers.IO){
            val response = postsService.getPost().execute()

            launch(Dispatchers.Main){
                if (response.isSuccessful) {
                    liveData.value = response.body()?.let { PostsState.Success(it) }
                }
                else {
                    Toast.makeText(getApplication(), "${response.body()}", Toast.LENGTH_SHORT).show()
                    liveData.value = PostsState.Error(response.body().toString())
                }
            }
        }
    }
    fun setPost(post: SetPost){
        liveData.value = PostsState.Loading
        postsService.setPost(post).enqueue(object : Callback<SetPostResponse>{
            override fun onResponse(call: Call<SetPostResponse>, response: Response<SetPostResponse>){
                liveData.value = PostsState.Done
                Toast.makeText(getApplication(), "nav", Toast.LENGTH_SHORT).show()
                if (response.isSuccessful){
                    Toast.makeText(getApplication(), "${response.body()}", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<SetPostResponse>, t: Throwable) {

            }
        })
    }

}