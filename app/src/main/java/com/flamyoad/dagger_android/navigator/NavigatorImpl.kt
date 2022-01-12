package com.flamyoad.dagger_android.navigator

import android.content.Context
import android.content.Intent
import com.flamyoad.dagger_android.MyApplication
import com.flamyoad.dagger_android.ui.main.MainActivity
import javax.inject.Inject

class NavigatorImpl @Inject constructor(private val app: MyApplication) : Navigator {

    override fun toMainActivity(context: Context) {
        val intent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        context.startActivity(intent)
    }
}