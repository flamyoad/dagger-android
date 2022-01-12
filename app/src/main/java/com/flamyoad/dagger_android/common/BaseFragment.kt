package com.flamyoad.dagger_android.common

import androidx.fragment.app.Fragment
import com.flamyoad.dagger_android.di.Injectable
import com.flamyoad.dagger_android.navigator.Navigator
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

open class BaseFragment: Fragment(), Injectable {
    val disposeBag = CompositeDisposable()

    @Inject
    lateinit var navigator: Navigator

    override fun onDestroyView() {
        super.onDestroyView()
        disposeBag.clear()
    }
}