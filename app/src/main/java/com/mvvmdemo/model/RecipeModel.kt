package com.mvvmdemo.model

import android.os.Parcelable
import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RecipeModel(var count: Int = 0,var recipes:List<Recipes>): Parcelable

@Parcelize
data class Recipes(var image_url: String? = null,
                   var social_rank: Double = 0.0,
                   var _id: String? = null,
                   var publisher: String? = null,
                   var source_url: String? = null,
                   var recipe_id: String? = null,
                   var publisher_url: String? = null,
                   var title: String? = null): Parcelable
