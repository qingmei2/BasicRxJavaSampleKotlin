package com.qingmei2.basicrxjavasamplekotlin.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import io.reactivex.Flowable

@Dao
interface UserDao {

    @Query("SELECT * FROM Users WHERE userid = :id")
    fun getUserById(id: String): Flowable<User>

    @Insert(onConflict = REPLACE)
    fun insertUser(user: User)

    @Query("DELETE FROM USERS")
    fun deleteAllUsers()
}