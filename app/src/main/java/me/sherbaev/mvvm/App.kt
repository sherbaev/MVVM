package me.sherbaev.mvvm

import android.app.Application
import me.sherbaev.mvvm.koin.appModule
import me.sherbaev.mvvm.koin.roomModule
import me.sherbaev.mvvm.koin.viewModelDependency
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(appModule, roomModule, viewModelDependency)
        }

    }
}