package com.mvvmdemo.viewmodels

import androidx.lifecycle.ViewModel
import com.mvvmdemo.retrofit.Repository


class MainViewModel(private val repository: Repository) : ViewModel() {


    fun getSearchApi()= repository.getUpdateImage()

    fun callSearchApi() = repository.getRandomImage()
}