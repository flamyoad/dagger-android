package com.flamyoad.dagger_android.api.todo

import com.flamyoad.dagger_android.ui.todo.Todo
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TodoResponse(
    val userId: Int?,
    val id: Int?,
    val title: String?,
    val completed: Boolean?,
)

fun TodoResponse.toModel(): Todo {
    return Todo(
        userId = userId ?: -1,
        id = userId ?: -1,
        title = title ?: "",
        completed = completed ?: false,
    )
}
