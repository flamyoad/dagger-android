package com.flamyoad.dagger_android.api.auth

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface AuthApi {
    @GET("users/{id}")
    fun login(@Path("id") id: Int): Single<UserResponse>
}