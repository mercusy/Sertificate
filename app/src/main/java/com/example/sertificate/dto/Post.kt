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
    val message: String?,
    val post: Post,
)
class Author(
    val name : String,
    val avtar : String
)
class PostsList: ArrayList<GetPost>()