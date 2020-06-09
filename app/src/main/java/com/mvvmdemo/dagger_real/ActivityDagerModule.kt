package com.mvvmdemo.dagger_real

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class ActivityDagerModule {

    companion object {
        @JvmStatic
        @Provides
        fun providesRestApi(mRetrofit: Retrofit): RestApi {
            return mRetrofit.create(RestApi::class.java)
        }

        @JvmStatic
        @Provides
        fun provideCustomAdapter():CustomAdapter{
            return  CustomAdapter()
        }
    }
}