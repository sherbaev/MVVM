package me.sherbaev.mvvm.model

import kotlinx.serialization.Serializable

@Serializable
data class Post(
    val id: Int? = 0,
    val title: String,
    val body: String,
    val userId: Int? = 0
)
