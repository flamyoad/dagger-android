package com.flamyoad.dagger_android.ui.main

import android.os.Bundle
import com.flamyoad.dagger_android.R
import com.flamyoad.dagger_android.common.BaseActivity

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}