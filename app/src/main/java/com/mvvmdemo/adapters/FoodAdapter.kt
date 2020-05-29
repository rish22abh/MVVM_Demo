package com.mvvmdemo.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mvvmdemo.R
import com.mvvmdemo.databinding.ItemFoodBinding
import com.mvvmdemo.model.Recipes

class  FoodAdapter(private val mContext: Context, private var mList:ArrayList<Recipes>): RecyclerView.Adapter<FoodAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemFoodBinding:ItemFoodBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext),R.layout.item_food, parent, false)
        return ViewHolder(itemFoodBinding)
    }

    override fun getItemCount(): Int {
       return mList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mList[position])
    }
    fun setData(mData : List<Recipes>){
        val count = itemCount
        mList.addAll(mData)
        notifyItemRangeInserted(count,mList.size-1)
    }

    class ViewHolder(private val itemFoodBinding: ItemFoodBinding):RecyclerView.ViewHolder(itemFoodBinding.root) {
        fun bind(mRecipes : Recipes){
            itemFoodBinding.mRecipes = mRecipes
        }
    }
}