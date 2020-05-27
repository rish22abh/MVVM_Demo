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
            httpClient.addInterceptor(mInterceptor)

            val client = httpClient.build()
            return Retrofit.Builder()
                .baseUrl("https://api.unsplash.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }

        private var mInterceptor = Interceptor { chain ->
            val original: Request = chain.request()
            val originalHttpUrl: HttpUrl = original.url()

            val url = originalHttpUrl.newBuilder()
                .addQueryParameter("client_id", "Xq0rVcO_vMgNB9nuprKseiDAhA_fcZobhRp0Q3n47b8")
                .build()
            val requestBuilder: Request.Builder = original.newBuilder()
                .url(url)

            val request: Request = requestBuilder.build()
            chain.proceed(request)
        }
    }
}