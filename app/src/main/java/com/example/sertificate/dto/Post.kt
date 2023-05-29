package com.example.sertificate.dto

class Post (
    val id : Int,
    val content: String,
    val author: Author,
    val comments : Int,
    val likes : Int,
    val shares : Int,
)
class GetPost(
    val message: Any,
    val posts: ListPost,
)
class SetPostResponse(
    val message: Any?,
    val post: Post
)
class Author(
    val name : String,
    val avatar : String
)
class SetPost(
    val author: String,
    val content: String
)
class ListPost: ArrayList<Post>()