package com.flamyoad.dagger_android.di

import com.flamyoad.dagger_android.EntryPointActivity
import com.flamyoad.dagger_android.di.login.LoginModule
import com.flamyoad.dagger_android.di.scope.ActivityScope
import com.flamyoad.dagger_android.ui.login.LoginActivity
import com.flamyoad.dagger_android.ui.main.MainActivity
import com.flamyoad.dagger_android.di.main.MainFragmentBindingModule
import com.flamyoad.dagger_android.di.todo.TodoModule
import com.flamyoad.dagger_android.di.todo.TodoViewModelsModule
import com.flamyoad.dagger_android.ui.user.UserModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {
    @ActivityScope
    @ContributesAndroidInjector
    abstract fun contributeEntryPointActivity(): EntryPointActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [
        LoginModule::class
    ])
    abstract fun contributeLoginActivity(): LoginActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [
        MainFragmentBindingModule::class,
        TodoViewModelsModule::class,
        TodoModule::class,
        UserModule::class,
    ])
    abstract fun contributeMainActivity(): MainActivity

}