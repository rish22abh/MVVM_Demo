package com.mvvmdemo.activity

import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mvvmdemo.R
import com.mvvmdemo.adapters.FoodAdapter
import com.mvvmdemo.databinding.ActivityMainBinding
import com.mvvmdemo.retrofit.Repository
import com.mvvmdemo.utils.EventHandler
import com.mvvmdemo.viewmodels.CustomFactory
import com.mvvmdemo.viewmodels.MainViewModel

class MainActivity : BaseActivity() {

    private lateinit var mAdapter: FoodAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(
                this,
                R.layout.activity_main
            )

        val mainViewModel: MainViewModel =
            ViewModelProvider(
                this,
                CustomFactory(Repository())
            ).get(MainViewModel::class.java)
        binding.handler = EventHandler(mainViewModel)

        mAdapter  = FoodAdapter(this,ArrayList())
        binding.mAdapter = mAdapter

        mainViewModel.getSearchApi().observe(this, Observer {
            Log.e("Rishabh", "obser-$it")
            mAdapter.setData(it!!.recipes)
        })
    }
}
