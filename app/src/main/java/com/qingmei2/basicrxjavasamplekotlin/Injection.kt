package com.qingmei2.basicrxjavasamplekotlin

import android.content.Context
import com.qingmei2.basicrxjavasamplekotlin.db.UserDao
import com.qingmei2.basicrxjavasamplekotlin.db.UserDatabase

object Injection {

    fun privateUserDataSource(context: Context): UserDao =
            UserDatabase.getInstance(context).userDao()

    fun privateViewModelFactory(context: Context): ViewModelFactory =
            ViewModelFactory(privateUserDataSource(context))
}