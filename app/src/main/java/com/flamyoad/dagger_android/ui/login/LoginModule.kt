package com.flamyoad.dagger_android.ui.login

import androidx.lifecycle.ViewModel
import com.flamyoad.dagger_android.di.ViewModelKey
import com.flamyoad.dagger_android.ui.login.LoginViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class LoginModule {
    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindLoginViewModel(viewModel: LoginViewModel): ViewModel
}
