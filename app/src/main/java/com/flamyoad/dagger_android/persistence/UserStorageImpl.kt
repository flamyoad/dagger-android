package com.flamyoad.dagger_android.persistence

import android.content.Context
import android.content.SharedPreferences
import com.flamyoad.dagger_android.MyApplication

class UserStorageImpl(private val app: MyApplication) : UserStorage {
    override fun writeInt(key: String, value: Int) {
        with(app.sharedPref().edit()) {
            putInt(key, value)
            apply()
        }
    }

    override fun writeString(key: String, value: String) {
        with(app.sharedPref().edit()) {
            putString(key, value)
            apply()
        }
    }

    override fun getInt(key: String): Int {
        return app.sharedPref().getInt(key, -1)
    }

    override fun getString(key: String): String {
        return app.sharedPref().getString(key, "") ?: ""
    }

    override fun delete(key: String) {
        app.sharedPref().edit().remove(key).apply()
    }

    private fun MyApplication.sharedPref(): SharedPreferences {
        return getSharedPreferences("shared_prefs", Context.MODE_PRIVATE)
    }
}