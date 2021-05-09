package me.sherbaev.mvvm.koin

import me.sherbaev.mvvm.viewmodel.PostViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelDependency = module {
    viewModel { PostViewModel(get()) }
}