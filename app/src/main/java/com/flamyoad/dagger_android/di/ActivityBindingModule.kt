package com.flamyoad.dagger_android.di

import com.flamyoad.dagger_android.MainActivity
import com.flamyoad.dagger_android.di.login.LoginModule
import com.flamyoad.dagger_android.di.scope.ActivityScope
import com.flamyoad.dagger_android.ui.login.LoginActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {
    @ContributesAndroidInjector
    @ActivityScope
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [
        LoginModule::class
    ])
    @ActivityScope
    abstract fun contributeLoginActivity(): LoginActivity

}