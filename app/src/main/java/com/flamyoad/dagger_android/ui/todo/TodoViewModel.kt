package com.flamyoad.dagger_android.ui.todo

import androidx.annotation.VisibleForTesting
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.flamyoad.dagger_android.services.todo.TodoService
import com.flamyoad.dagger_android.utils.applyIoScheduler
import io.reactivex.rxjava3.kotlin.subscribeBy
import javax.inject.Inject

class TodoViewModel @Inject constructor(private val todoService: TodoService) : ViewModel() {

    val todoList = ObservableField<List<Todo>>()

    val isLoading = ObservableBoolean()
    val isError = ObservableBoolean()

    init {
        getTodos()
    }

    @VisibleForTesting
    fun getTodos() {
        todoService.getTodos()
            .doOnSubscribe { isLoading.set(true) }
            .doOnError { e -> isError.set(true) }
            .applyIoScheduler()
            .subscribeBy(onSuccess = { todoList.set(it) })
    }
}