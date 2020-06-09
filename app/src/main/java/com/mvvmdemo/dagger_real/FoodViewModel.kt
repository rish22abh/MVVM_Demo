package com.mvvmdemo.dagger_real

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mvvmdemo.model.RecipeModel
import javax.inject.Inject


class FoodViewModel @Inject constructor(var mApiRepository: ApiRepository) : ViewModel() {

    fun getFoodData(mQuery: String): MutableLiveData<RecipeModel> {
        return mApiRepository.getRecipeList(mQuery)
    }
}