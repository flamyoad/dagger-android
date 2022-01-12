package com.flamyoad.dagger_android.di

import com.flamyoad.dagger_android.MyApplication
import com.flamyoad.dagger_android.di.scope.ApplicationScope
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@ApplicationScope
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ActivityBindingModule::class,
    ViewModelFactoryModule::class,
    AppModule::class,
    ApiModule::class,
    ServiceModule::class,
])
interface AppComponent: AndroidInjector<MyApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: MyApplication): Builder

        fun build(): AppComponent
    }
}

//@Component(modules = [AppModule::class, ...])
//@Singleton
//interface AppComponent : AndroidInjector<MyApp> {
//
//    @Component.Factory
//    interface Factory : AndroidInjector.Factory<MyApp> {
//        override fun create(@BindsInstance instance: MyApp): AppComponent
//    }
//}