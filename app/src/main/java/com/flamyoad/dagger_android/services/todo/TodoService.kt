package com.flamyoad.dagger_android.services.todo

import com.flamyoad.dagger_android.ui.todo.Todo
import io.reactivex.rxjava3.core.Single

interface TodoService {
    fun getTodos(): Single<List<Todo>>
}