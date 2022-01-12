package com.flamyoad.dagger_android.di

import com.flamyoad.dagger_android.MyApplication
import com.flamyoad.dagger_android.di.scope.ApplicationScope
import com.flamyoad.dagger_android.navigator.Navigator
import com.flamyoad.dagger_android.navigator.NavigatorImpl
import com.flamyoad.dagger_android.persistence.UserStorage
import com.flamyoad.dagger_android.persistence.UserStorageImpl
import dagger.Module
import dagger.Provides

@Module
class AppModule {

//    @Binds
//    abstract fun noobString(str: String): String

    @get:Provides
    val provideString: String = "hehe"

    @ApplicationScope
    @Provides
    fun provideNavigator(app: MyApplication): Navigator {
        return NavigatorImpl(app)
    }

    @ApplicationScope
    @Provides
    fun provideUserStorage(app: MyApplication): UserStorage {
        return UserStorageImpl(app)
    }
}