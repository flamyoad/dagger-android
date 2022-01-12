package com.flamyoad.dagger_android.ui.user

import androidx.annotation.VisibleForTesting
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.flamyoad.dagger_android.api.auth.UserResponse
import com.flamyoad.dagger_android.services.auth.AuthService
import com.flamyoad.dagger_android.utils.applyIoScheduler
import io.reactivex.rxjava3.kotlin.subscribeBy
import javax.inject.Inject

class UserViewModel @Inject constructor(private val authService: AuthService) : ViewModel() {
    val userId = ObservableField<String>()
    val userName = ObservableField<String>()

    val isLoading = ObservableField<Boolean>()
    val isError = ObservableField<Boolean>()
    val isContent = ObservableField<Boolean>()

    init {
        getUserInfo()
    }

    @VisibleForTesting
    fun getUserInfo() {
        authService.getUserInfo()
            .doOnSubscribe {
                isLoading.set(true)
                isError.set(false)
            }
            .doFinally { isLoading.set(false) }
            .applyIoScheduler()
            .subscribeBy(
                onSuccess = { show(it) },
                onError = { e -> isError.set(true) }
            )
    }

    @VisibleForTesting
    fun show(user: UserResponse) {
        userId.set(user.id.toString())
        userName.set(user.name.toString())
        isContent.set(true)
    }
}