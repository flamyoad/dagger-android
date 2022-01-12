package com.flamyoad.dagger_android.di

import androidx.lifecycle.ViewModelProvider
import com.flamyoad.dagger_android.common.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}