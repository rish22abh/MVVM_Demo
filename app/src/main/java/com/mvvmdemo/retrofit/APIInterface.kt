package com.mvvmdemo.retrofit

import com.mvvmdemo.model.PhotosModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIInterface {
    @GET("/photos/random/")
    fun doGetRandomImage(): Call<PhotosModel?>?

    @GET("/photos/")
    fun doGetImageList(@Query("page") page:Int): Call<List<PhotosModel>?>?
}