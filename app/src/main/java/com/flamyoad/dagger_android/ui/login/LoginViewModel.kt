package com.flamyoad.dagger_android.ui.login

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import java.lang.Exception
import javax.inject.Inject

// Even if vm is empty, if you dont put @Inject constructor() it will return err
class LoginViewModel @Inject constructor(): ViewModel() {

    val userName = ObservableField<String>()
    val password = ObservableField<String>()

    fun login() {
        println(userName.get() + " " + password.get())
    }
}