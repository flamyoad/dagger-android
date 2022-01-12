package com.flamyoad.dagger_android.services

import com.flamyoad.dagger_android.api.auth.AuthApi
import com.flamyoad.dagger_android.api.auth.UserResponse
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class AuthService @Inject constructor(private val authApi: AuthApi) {
    fun login(userId: Int, password: String): Single<UserResponse> {
        return authApi.login(userId)
    }
}