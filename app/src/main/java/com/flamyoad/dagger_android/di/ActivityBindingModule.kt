package com.flamyoad.dagger_android.di

import com.flamyoad.dagger_android.MainActivity
import com.flamyoad.dagger_android.di.login.LoginModule
import com.flamyoad.dagger_android.ui.login.LoginActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector(
        modules = [LoginModule::class]
    )
    abstract fun contributeLoginActivity(): LoginActivity

}