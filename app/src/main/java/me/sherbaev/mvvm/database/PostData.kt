package me.sherbaev.mvvm.database

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
class PostData(
    val title: String,
    val body: String,
    @PrimaryKey(autoGenerate = true)
    val id: Long=0
)