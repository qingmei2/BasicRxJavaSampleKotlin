package com.qingmei2.basicrxjavasamplekotlin

import android.arch.lifecycle.ViewModel
import com.qingmei2.basicrxjavasamplekotlin.db.User
import com.qingmei2.basicrxjavasamplekotlin.db.UserDao
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val userDao: UserDao) : ViewModel() {

    fun userName(): Flowable<String> = userDao.getUserById(USER_ID)
            .map { it.username }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    fun updateUserName(newName: String): Completable = Completable.fromAction {
        val user = User(USER_ID, newName)
        userDao.insertUser(user)
    }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    companion object {

        const val USER_ID = "1"
    }
}