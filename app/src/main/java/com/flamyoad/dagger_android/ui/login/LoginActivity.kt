package com.flamyoad.dagger_android.ui.login

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.flamyoad.dagger_android.R
import com.flamyoad.dagger_android.common.ViewModelFactory
import dagger.android.AndroidInjection
import dagger.android.DaggerActivity
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {
    @Inject
    lateinit var vmFactory: ViewModelFactory

    private val viewModel: LoginViewModel by viewModels { vmFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
}