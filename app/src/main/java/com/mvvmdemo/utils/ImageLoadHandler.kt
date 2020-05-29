package com.mvvmdemo.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

class ImageLoadHandler{
    companion object {
    }

    fun loadImage(context: Context,mImageUrl:String,mImageView : ImageView,placeHolder:Int){
        Glide.with(context).load(mImageUrl).placeholder(placeHolder).into(mImageView)
    }
}