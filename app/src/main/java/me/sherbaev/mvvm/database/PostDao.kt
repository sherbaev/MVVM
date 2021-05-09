package me.sherbaev.mvvm.database

import androidx.lifecycle.LiveData
import androidx.room.*
import me.sherbaev.mvvm.model.Post

@Dao
interface PostDao {
    @Insert
    suspend fun addPost(postData: PostData)

    @Update
    suspend fun updatePost(postData: PostData)

    @Delete
    suspend fun deletePost(postData: PostData)

    @Query("select * from postdata")
    suspend fun loadPosts(): List<PostData>
}