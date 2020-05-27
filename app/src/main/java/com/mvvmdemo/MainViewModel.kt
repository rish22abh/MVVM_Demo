package com.mvvmdemo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MainViewModel(private val repository: Repository) : ViewModel() {


    fun getSearchApi()= repository.getUpdateImage()

    fun callSearchApi() = repository.getRandomImage()
}