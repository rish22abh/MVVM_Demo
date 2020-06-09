package com.mvvmdemo.dagger_real

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mvvmdemo.databinding.ItemFoodBinding
import com.mvvmdemo.model.Recipes

class CustomAdapter() : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    private  var  mList:ArrayList<Recipes> = ArrayList()

    class ViewHolder( var mItemView:ItemFoodBinding):RecyclerView.ViewHolder(mItemView.root) {
        fun bind(mRecipes: Recipes){
            mItemView.mRecipes = mRecipes
        }
    }

    fun setData(mData : List<Recipes>){
        var count = mList.size
        mList.addAll(mData)
        notifyItemRangeInserted(count,mData.size-1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(ItemFoodBinding.inflate(inflater))
    }

    override fun getItemCount(): Int {
        return mList.size
    }
    override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) {
        holder.bind(mList[position])
    }
}