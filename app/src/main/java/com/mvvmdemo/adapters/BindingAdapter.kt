package com.mvvmdemo.adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("loadimage")
fun loadImage(mView : ImageView, str:String){
    Glide.with(mView.context).load(str).into(mView)
}