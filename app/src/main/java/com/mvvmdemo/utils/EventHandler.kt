package com.mvvmdemo.utils

import android.view.View
import android.widget.Toast
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import com.mvvmdemo.viewmodels.MainViewModel

class EventHandler(private var mainViewModel: MainViewModel) :
    BaseObservable() {
    private var isErrorVisible = View.GONE
    fun searchClicked(view: View, searchText: String) {
        if (searchText.isNotEmpty()) {
            setErrorVisibility(View.GONE)
            mainViewModel.callSearchApi(searchText)
        } else {
            setErrorVisibility(View.VISIBLE)
            Toast.makeText(view.context, "clicked-$searchText", Toast.LENGTH_LONG).show()
        }
    }

    @Bindable
    fun getErrorVisibility(): Int {
        return isErrorVisible
    }

    private fun setErrorVisibility(visibility: Int) {
        isErrorVisible = visibility
        notifyPropertyChanged(BR.errorVisibility)
    }
}