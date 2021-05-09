package me.sherbaev.mvvm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.post_item.view.*
import me.sherbaev.mvvm.R
import me.sherbaev.mvvm.model.Post

class PostAdapter : RecyclerView.Adapter<PostAdapter.ViewHolder>() {
    private val posts by lazy { ArrayList<Post>() }

    fun initData(data: ArrayList<Post>) {
        posts.clear()
        posts.addAll(data)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(post: Post) {
            itemView.tvTitle.text = post.title
            itemView.tvDesc.text = post.body

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(posts[position])
    }

    override fun getItemCount() = posts.size
}