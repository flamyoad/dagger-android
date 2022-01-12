package com.flamyoad.dagger_android.services.auth

import com.flamyoad.dagger_android.api.auth.UserResponse
import io.reactivex.rxjava3.core.Single

interface AuthService {
    fun login(userId: Int, password: String): Single<UserResponse>
    fun logout(): Single<Unit>
}