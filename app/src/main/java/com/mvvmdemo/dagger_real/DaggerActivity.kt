package com.mvvmdemo.dagger_real;

import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mvvmdemo.R
import com.mvvmdemo.databinding.ActivityDaggerActivtyBinding
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class DaggerActivity() : DaggerAppCompatActivity() {
    @Inject
    lateinit var mViewModelFactory: ViewModelFactory

    @Inject
    lateinit var mCustomAdapter: CustomAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dagger_activty)
        val mActivtyBinding = DataBindingUtil.setContentView<ActivityDaggerActivtyBinding>(this,R.layout.activity_dagger_activty)
        mActivtyBinding.adapter = mCustomAdapter
        val mFoodViewModel = ViewModelProvider(this, mViewModelFactory)[FoodViewModel::class.java]
        mFoodViewModel.getFoodData("chi").observe(this, Observer {
            Log.d("Data", it.recipes.toString())
            mCustomAdapter.setData(it.recipes)
        })
    }
}
