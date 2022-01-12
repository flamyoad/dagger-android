package com.flamyoad.dagger_android

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.flamyoad.dagger_android.common.BaseActivity
import com.flamyoad.dagger_android.ui.login.LoginActivity
import javax.inject.Inject

class EntryPointActivity : BaseActivity() {

    @Inject
    lateinit var noobString: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entry_point)
        // https://jsonplaceholder.typicode.com/
        Log.d("hehe", "onCreate: " + noobString.hashCode().toString())

        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}