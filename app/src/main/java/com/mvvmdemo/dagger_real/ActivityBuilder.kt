package com.mvvmdemo.dagger_real

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [ViewModelModule::class,ActivityDagerModule::class])
    abstract fun contributeDaggerActivity():DaggerActivity

}