package com.example.projectkelompok

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

// Endpoint API untuk post
interface PostApiService {
    @GET("tes.json")
    suspend fun getPosts(): List<Post>

    @GET("Fransis96/Project-Mobile/main/source/about.txt")
    suspend fun getAboutApp(): String
}

// Inisialisasi Retrofit
object RetrofitInstance {
    private const val BASE_URL = "https://raw.githubusercontent.com/Fransis96/Project-Mobile/main/source/"

    val api: PostApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PostApiService::class.java)
    }
}

