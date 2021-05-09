package me.sherbaev.mvvm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import me.sherbaev.mvvm.adapter.PostAdapter
import me.sherbaev.mvvm.extensions.isOnline
import me.sherbaev.mvvm.viewmodel.PostViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    val model: PostViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = PostAdapter()
        rvPost.adapter = adapter
        model.postLiveData.observe(this, {
            if (this.isOnline()) {
                model.insertPosts(it)
            }
            adapter.initData(ArrayList(it))
            adapter.notifyDataSetChanged()
        })
    }
}