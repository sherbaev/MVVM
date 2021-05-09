package me.sherbaev.mvvm.koin

import me.sherbaev.mvvm.database.PostDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val roomModule = module {
    single { PostDatabase.getDataseClient(androidContext()) }
    single { get<PostDatabase>().loadDao() }
}