package com.flamyoad.dagger_android.di

import com.flamyoad.dagger_android.api.auth.AuthApi
import com.flamyoad.dagger_android.di.scope.ApplicationScope
import com.flamyoad.dagger_android.persistence.UserStorage
import com.flamyoad.dagger_android.services.auth.AuthService
import com.flamyoad.dagger_android.services.auth.AuthServiceImpl
import dagger.Module
import dagger.Provides

@Module
class ServiceModule {

    @ApplicationScope
    @Provides
    fun provideAuthService(authApi: AuthApi, userStorage: UserStorage): AuthService {
        return AuthServiceImpl(authApi, userStorage)
    }
}