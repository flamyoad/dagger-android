package com.flamyoad.dagger_android.di.main

import com.flamyoad.dagger_android.ui.todo.TodoFragment
import com.flamyoad.dagger_android.ui.user.UserFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentBindingModule {

    @ContributesAndroidInjector
    abstract fun contributeTodoFragment(): TodoFragment

    @ContributesAndroidInjector
    abstract fun contributeUserFragment(): UserFragment
}