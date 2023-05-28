package com.example.sertificate.dto

class Post (
    val id : Int,
    val content: String,
    val author: Author,
    val comments : Int,
    val liked : Int,
    val shares : Int,
)
class GetPost(
    val message: Any? = null,
    val post: ListPosts,
)
class Author(
    val name : String,
    val avtar : String
)
class SetPost(
    val author: String,
    val content: String,
)
class ListPosts: ArrayList<Post>()