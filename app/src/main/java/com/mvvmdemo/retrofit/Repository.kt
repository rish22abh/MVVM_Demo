package com.mvvmdemo.retrofit

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.mvvmdemo.model.RecipeModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {
    private var apiInterface: APIInterface = APIClient.getClient().create(
        APIInterface::class.java
    )
    val recipeModelData = MutableLiveData<RecipeModel>()
    fun getRecipeList(searchText: String) {
        val callRandomImage: Call<RecipeModel>? = apiInterface.doGetRecipeList(searchText, 1)
        callRandomImage?.enqueue(object : Callback<RecipeModel?> {
            override fun onFailure(call: Call<RecipeModel?>, t: Throwable) {
                Log.e("Rishabh", "onFailure-$t")
            }

            override fun onResponse(
                call: Call<RecipeModel?>,
                response: Response<RecipeModel?>
            ) {
                Log.e("Rishabh", "onResponse-" + response.body())
                recipeModelData.value = response.body()
            }
        })
    }

    fun getSearchList(): MutableLiveData<RecipeModel> {
        return recipeModelData
    }
}