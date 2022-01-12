package com.flamyoad.dagger_android.persistence

interface UserStorage {

    fun writeInt(key: String, value: Int)
    fun writeString(key: String, value: String)

    fun getInt(key: String): Int
    fun getString(key: String): String
}