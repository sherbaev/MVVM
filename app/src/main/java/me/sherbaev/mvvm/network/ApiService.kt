package me.sherbaev.mvvm.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit


object ApiService {
    val contentType = "application/json".toMediaType()
    val client = OkHttpClient()
        .newBuilder()
        .connectTimeout(50, TimeUnit.SECONDS)
        .writeTimeout(50, TimeUnit.SECONDS)
        .readTimeout(50, TimeUnit.SECONDS)
        .build()

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .client(client)
            .addConverterFactory(Json.asConverterFactory(contentType))
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .build()
    }

    val service: ApiInterface = getRetrofit()
        .create(
            ApiInterface::class.java
        )
}