package me.sherbaev.mvvm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import me.sherbaev.mvvm.model.Post
import me.sherbaev.mvvm.repository.PostRepository

class PostViewModel(private val repository: PostRepository) : ViewModel() {

    val postLiveData = liveData {
        val data = repository.loadPosts()
        emit(data)
    }

    fun insertPosts(list: List<Post>) = viewModelScope.launch {
        repository.insertPosts(list)
    }
}