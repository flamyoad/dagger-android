package com.flamyoad.dagger_android.ui.todo

data class Todo(
    val userId: Int,
    val id: Int,
    val title: String,
    val completed: Boolean,
)