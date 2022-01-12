package com.flamyoad.dagger_android.services.auth

import com.flamyoad.dagger_android.api.auth.AuthApi
import com.flamyoad.dagger_android.api.auth.UserResponse
import com.flamyoad.dagger_android.persistence.UserStorage
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class AuthServiceImpl @Inject constructor(
    private val authApi: AuthApi,
    private val userStorage: UserStorage
): AuthService {

    override fun login(userId: Int, password: String): Single<UserResponse> {
        return authApi.login(userId).doAfterSuccess {
            userStorage.writeInt(ACCOUNT_ID, userId)
        }
    }

    override fun logout(): Single<Unit> {
        return Single.fromCallable {
            userStorage.delete(ACCOUNT_ID)
        }
    }

    companion object {
        private const val ACCOUNT_ID = "account_id"
    }
}