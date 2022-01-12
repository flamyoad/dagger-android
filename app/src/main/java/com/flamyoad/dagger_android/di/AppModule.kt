package com.flamyoad.dagger_android.di

import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
class AppModule {

//    @Binds
//    abstract fun noobString(str: String): String

    @get:Provides
    val provideString: String = "hehe"
}