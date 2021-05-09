package me.sherbaev.mvvm.koin

import me.sherbaev.mvvm.repository.PostRepository
import org.koin.core.component.KoinApiExtension
import org.koin.dsl.module

@OptIn(KoinApiExtension::class)
val appModule = module {
    single { PostRepository(get()) }
}
