package com.flamyoad.dagger_android

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.flamyoad.dagger_android.common.BaseActivity
import com.flamyoad.dagger_android.ui.login.LoginActivity
import javax.inject.Inject

class EntryPointActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entry_point)

        val intent = Intent(this, LoginActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        startActivity(intent)
    }
}