package com.flamyoad.dagger_android.ui.user

import androidx.lifecycle.ViewModel
import com.flamyoad.dagger_android.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class UserModule {
    @Binds
    @IntoMap
    @ViewModelKey(UserViewModel::class)
    abstract fun bindUserViewModel(viewModel: UserViewModel): ViewModel
}