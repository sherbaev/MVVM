package me.sherbaev.mvvm.extensions

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import me.sherbaev.mvvm.database.PostData
import me.sherbaev.mvvm.model.Post

fun List<PostData>.toPostList(): List<Post> {
    val list = ArrayList<Post>()
    this.forEach {
        list.add(Post(title = it.title, body = it.body))
    }
    return list
}


fun List<Post>.toPostDataList(): List<PostData> {
    val list = ArrayList<PostData>()
    this.forEach {
        list.add(PostData(title = it.title, body = it.body))
    }
    return list
}

fun Context.isOnline(): Boolean {
    val connMgr = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val networkInfo: NetworkInfo? = connMgr.activeNetworkInfo
    return networkInfo?.isConnected == true
}