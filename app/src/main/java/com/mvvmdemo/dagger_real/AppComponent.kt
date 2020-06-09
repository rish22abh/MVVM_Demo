package com.mvvmdemo.dagger_real

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class,AppModule::class,ViewModelFactoryModule::class,ActivityBuilder::class])
interface AppComponent : AndroidInjector<FoodApp>{

    @Component.Builder
    interface Builder{
        @BindsInstance fun bindApplication(mApplication: Application): Builder
        @BindsInstance fun bindBaseUrl(@Named("base_url")mString: String): Builder

        fun build():AppComponent
    }
}