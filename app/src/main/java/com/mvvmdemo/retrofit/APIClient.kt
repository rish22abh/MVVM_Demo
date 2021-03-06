package com.mvvmdemo.retrofit

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIClient {
    companion object {
        fun getClient(): Retrofit {
            val httpClient = OkHttpClient.Builder()
            val client = httpClient.build()
            return Retrofit.Builder()
                .baseUrl("https://recipesapi.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }
    }
}