package com.mvvmdemo.adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.mvvmdemo.utils.ImageLoadHandler

@BindingAdapter("loadimage")
fun loadImage(mView : ImageView, str:String){
    ImageLoadHandler().loadImage(mView.context,str,mView,0)
}