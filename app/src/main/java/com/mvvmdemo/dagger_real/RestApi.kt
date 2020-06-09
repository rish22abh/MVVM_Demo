package com.mvvmdemo.dagger_real

import com.mvvmdemo.model.RecipeModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RestApi {
    @GET("search/")
    fun doGetRecipeList(
        @Query("q") searchText: String,
        @Query("page") page: Int
    ): Call<RecipeModel>?
}