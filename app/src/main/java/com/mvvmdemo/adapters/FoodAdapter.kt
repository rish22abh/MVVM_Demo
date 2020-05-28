package com.mvvmdemo.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mvvmdemo.databinding.ItemFoodBinding
import com.mvvmdemo.model.Recipes

class  FoodAdapter(private val mContext: Context, private val mList:List<Recipes>): RecyclerView.Adapter<FoodAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemFoodBinding = ItemFoodBinding.inflate(LayoutInflater.from(mContext))
        return ViewHolder(itemFoodBinding)
    }

    override fun getItemCount(): Int {
       return mList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mList[position])
    }

    class ViewHolder(private val itemFoodBinding: ItemFoodBinding):RecyclerView.ViewHolder(itemFoodBinding.root) {
        fun bind(mRecipes : Recipes){
            itemFoodBinding.mRecipes = mRecipes
        }
    }
}