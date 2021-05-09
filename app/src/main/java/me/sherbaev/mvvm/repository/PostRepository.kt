package me.sherbaev.mvvm.repository

import me.sherbaev.mvvm.database.PostData
import me.sherbaev.mvvm.database.PostDatabase
import me.sherbaev.mvvm.extensions.toPostDataList
import me.sherbaev.mvvm.extensions.toPostList
import me.sherbaev.mvvm.model.Post
import me.sherbaev.mvvm.network.ApiService

class PostRepository(private val database: PostDatabase) {
    val service = ApiService.service
    val dao by lazy { database.loadDao() }

    suspend fun loadPosts(): List<Post> {
        return try {
            service.loadPosts()
        } catch (e: Exception) {
            dao.loadPosts().toPostList()
        }
    }

    suspend fun insertPosts(data: List<Post>) {
        dao.loadPosts().forEach {
            dao.deletePost(it)
        }
        data.toPostDataList().forEach {
            dao.addPost(it)
        }
    }
}