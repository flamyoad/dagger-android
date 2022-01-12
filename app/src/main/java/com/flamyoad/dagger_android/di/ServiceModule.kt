package com.flamyoad.dagger_android.di

import com.flamyoad.dagger_android.api.auth.AuthApi
import com.flamyoad.dagger_android.api.todo.TodoApi
import com.flamyoad.dagger_android.di.scope.ActivityScope
import com.flamyoad.dagger_android.di.scope.ApplicationScope
import com.flamyoad.dagger_android.persistence.UserStorage
import com.flamyoad.dagger_android.services.auth.AuthService
import com.flamyoad.dagger_android.services.auth.AuthServiceImpl
import com.flamyoad.dagger_android.services.todo.TodoService
import com.flamyoad.dagger_android.services.todo.TodoServiceImpl
import dagger.Module
import dagger.Provides

@Module
class ServiceModule {

    @ApplicationScope
    @Provides
    fun provideAuthService(authApi: AuthApi, userStorage: UserStorage): AuthService {
        return AuthServiceImpl(authApi, userStorage)
    }

    // Any module's @Provides method may only have the same scope as the component they are part of.
    // if change to @ActivityScope will give error: ApplicationScope may not reference bindings with different scopes:
    @ApplicationScope
    @Provides
    fun provideTodoService(todoApi: TodoApi, authService: AuthService): TodoService {
        return TodoServiceImpl(todoApi, authService)
    }
}