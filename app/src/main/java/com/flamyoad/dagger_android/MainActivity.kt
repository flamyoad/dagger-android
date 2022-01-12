package com.flamyoad.dagger_android

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.flamyoad.dagger_android.di.Injectable
import com.flamyoad.dagger_android.ui.login.LoginActivity
import dagger.android.DaggerActivity
import javax.inject.Inject

class MainActivity : AppCompatActivity(), Injectable {

    @Inject
    lateinit var noobString: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // https://jsonplaceholder.typicode.com/
        Log.d("hehe", "onCreate: " + noobString.hashCode().toString())

        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}