package com.flamyoad.dagger_android.api.todo

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface TodoApi {
    @GET("todos")
    fun getTodos(@Query("userId") userId: Int): Single<List<TodoResponse>>
}