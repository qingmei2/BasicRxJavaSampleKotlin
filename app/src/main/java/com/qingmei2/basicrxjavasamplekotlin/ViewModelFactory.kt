package com.qingmei2.basicrxjavasamplekotlin

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.qingmei2.basicrxjavasamplekotlin.db.UserDao

class ViewModelFactory(private val dataSource: UserDao) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(dataSource) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}