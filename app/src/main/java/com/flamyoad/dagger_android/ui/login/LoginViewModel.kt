package com.flamyoad.dagger_android.ui.login

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.flamyoad.dagger_android.navigator.Navigator
import com.flamyoad.dagger_android.services.AuthService
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.PublishSubject
import java.util.concurrent.TimeUnit
import javax.inject.Inject

// Even if vm is empty, if you dont put @Inject constructor() it will return err
class LoginViewModel @Inject constructor(
    private val authService: AuthService,
) : ViewModel() {

    private val disposeBag = CompositeDisposable()

    val userId = ObservableField<String>()
    val password = ObservableField<String>()
    val isLoading = ObservableBoolean(false)
    val isLoginError = ObservableBoolean(false)

    val navigateToMain: PublishSubject<Boolean> = PublishSubject.create<Boolean>()

    fun login() {
        val formattedUserId = userId.get()?.toIntOrNull() ?: return
        val formattedPassword = password.get() ?: return

        authService.login(formattedUserId, formattedPassword)
            .delay(100, TimeUnit.MILLISECONDS)
            .doOnSubscribe { isLoading.set(true) }
            .doFinally { isLoading.set(false) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = { navigateToMain.onNext(true) },
                onError = { isLoginError.set(true) },
            ).addTo(disposeBag)
    }

    override fun onCleared() {
        super.onCleared()
        disposeBag.clear()
    }
}