package com.flamyoad.dagger_android.ui.login

import androidx.lifecycle.ViewModel
import javax.inject.Inject

// Even if vm is empty, if you dont put @Inject constructor() it will return err
class LoginViewModel @Inject constructor(): ViewModel() {
}