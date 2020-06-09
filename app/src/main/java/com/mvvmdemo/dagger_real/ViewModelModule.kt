package com.mvvmdemo.dagger_real

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(FoodViewModel::class)
    abstract fun bindFoodViewMode(mFoodViewModel: FoodViewModel):ViewModel
}