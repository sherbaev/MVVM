package me.sherbaev.mvvm.network

import me.sherbaev.mvvm.model.Post
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("/posts")
    suspend fun loadPosts(): List<Post>
}