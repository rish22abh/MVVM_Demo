package com.mvvmdemo.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.mvvmdemo.R
import com.mvvmdemo.dagger_real.DaggerActivity

class SplashActivity : BaseActivity() {

    lateinit var mHandler: Handler
    private var mRunnable = Runnable {
        startActivity(Intent(this, DaggerActivity::class.java))
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        mHandler = Handler()
    }

    override fun onResume() {
        super.onResume()
        mHandler.postDelayed(mRunnable, 3000)
    }

    override fun onPause() {
        super.onPause()
        mHandler.removeCallbacks(mRunnable)
    }
}