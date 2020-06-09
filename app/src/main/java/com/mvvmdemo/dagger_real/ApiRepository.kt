package com.mvvmdemo.dagger_real

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.mvvmdemo.model.RecipeModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class ApiRepository @Inject constructor() {

    @Inject
    lateinit var mRestApi: RestApi

    val recipeModelData = MutableLiveData<RecipeModel>()

    fun getRecipeList(searchText: String)  :  MutableLiveData<RecipeModel> {
        val callRandomImage: Call<RecipeModel>? = mRestApi.doGetRecipeList(searchText, 1)
        callRandomImage?.enqueue(object : Callback<RecipeModel?> {
            override fun onFailure(call: Call<RecipeModel?>, t: Throwable) {
                Log.e("Rishabh", "onFailure-$t")
                recipeModelData.value = null
            }

            override fun onResponse(
                call: Call<RecipeModel?>,
                response: Response<RecipeModel?>
            ) {
                Log.e("Rishabh", "onResponse-" + response.body())
                recipeModelData.value = response.body()
            }
        })
        return recipeModelData
    }

    fun getSearchList( response: Response<RecipeModel?>): MutableLiveData<RecipeModel> {
        recipeModelData.value = response.body()
        return recipeModelData
    }

}