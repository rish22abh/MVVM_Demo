package com.mvvmdemo.dagger_real

import android.app.Application
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.mvvmdemo.R
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun providesRequestOptions(): RequestOptions {
        return RequestOptions.placeholderOf(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher)
    }

    @Singleton
    @Provides
    fun providesRequestManager(mApplication: Application, mRequestOptions: RequestOptions): RequestManager {
        return Glide.with(mApplication).setDefaultRequestOptions(mRequestOptions)
    }

    @Singleton
    @Provides
    fun providesRetrofit(@Named("base_url") mBaseUrl : String): Retrofit {
        return Retrofit.Builder().baseUrl(mBaseUrl).
        addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}