package com.flamyoad.dagger_android.di.todo

import com.flamyoad.dagger_android.di.scope.ActivityScope
import com.flamyoad.dagger_android.ui.todo.TodoAdapter
import dagger.Module
import dagger.Provides

@Module
class TodoModule {

    @ActivityScope
    @Provides
    fun provideTodoAdapter(): TodoAdapter = TodoAdapter()
}