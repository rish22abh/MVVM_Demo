package com.mvvmdemo

import android.app.Application
import javax.inject.Inject


class MyApplication @Inject constructor(): Application() {

//    private lateinit var mAppComponent: ApplicationGraph

    override fun onCreate() {
        super.onCreate()

        // Dagger%COMPONENT_NAME%
//        mAppComponent =
//            DaggerApplicationGraph.builder() // list of modules that are part of this component need to be created here too
//                .aPIClient(APIClient()) // This also corresponds to the name of your module: %component_name%Module
//                .build()
        // If a Dagger 2 component does not have any constructor arguments for any of its modules,
        // then we can use .create() as a shortcut instead:
        //  mAppComponent = com.codepath.dagger.components.DaggerAppComponent.create();
    }

//    fun getAppComponent(): ApplicationGraph {
//        return mAppComponent
//    }
}