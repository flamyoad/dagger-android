package com.flamyoad.dagger_android.common

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.flamyoad.dagger_android.navigator.Navigator
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

open class BaseActivity: AppCompatActivity(), HasSupportFragmentInjector {

    protected val disposeBag = CompositeDisposable()

    @Inject
    lateinit var navigator: Navigator

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentInjector

    override fun onDestroy() {
        super.onDestroy()
        disposeBag.clear()
    }
}