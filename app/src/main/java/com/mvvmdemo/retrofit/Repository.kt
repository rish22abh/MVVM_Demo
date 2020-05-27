package com.mvvmdemo.retrofit

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.mvvmdemo.model.PhotosModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {
    private var apiInterface: APIInterface = APIClient.getClient().create(
        APIInterface::class.java)
    val randomImageModel = MutableLiveData<PhotosModel>()
    fun getRandomImage() {
        val callRandomImage: Call<PhotosModel?>? = apiInterface.doGetRandomImage()
        callRandomImage?.enqueue(object : Callback<PhotosModel?> {
            override fun onFailure(call: Call<PhotosModel?>, t: Throwable) {
                Log.e("Rishabh", "onFailure-$t")
            }

            override fun onResponse(
                call: Call<PhotosModel?>,
                response: Response<PhotosModel?>
            ) {
                Log.e("Rishabh", "onResponse-" + response.body())
                randomImageModel.value = response.body()
            }
        })

    }

    fun getUpdateImage(): MutableLiveData<PhotosModel> {
        return randomImageModel
    }
}