package com.mvvmdemo.dagger_real

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class FoodApp : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().bindApplication(this).bindBaseUrl("https://recipesapi.herokuapp.com/api/").build()
    }
}