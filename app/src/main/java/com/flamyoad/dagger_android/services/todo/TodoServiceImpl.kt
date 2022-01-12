package com.flamyoad.dagger_android.services.todo

import com.flamyoad.dagger_android.api.todo.TodoApi
import com.flamyoad.dagger_android.api.todo.TodoResponse
import com.flamyoad.dagger_android.api.todo.toModel
import com.flamyoad.dagger_android.persistence.UserStorage
import com.flamyoad.dagger_android.services.auth.AuthService
import com.flamyoad.dagger_android.ui.todo.Todo
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class TodoServiceImpl @Inject constructor(
    private val todoApi: TodoApi,
    private val authService: AuthService,
) : TodoService {

    override fun getTodos(): Single<List<Todo>> {
        return authService.getUserInfo()
            .flatMap {
                val userId = it.id ?: return@flatMap Single.just(emptyList())
                todoApi.getTodos(userId).map { it.map { it.toModel() } }
            }
    }

}