package com.mvvmdemo.dagger_real

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {

    @Binds
    internal abstract fun bindVimFactory(mViewModelFactory: ViewModelFactory): ViewModelProvider.Factory

}