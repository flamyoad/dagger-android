package com.flamyoad.dagger_android.di.todo

import androidx.lifecycle.ViewModel
import com.flamyoad.dagger_android.di.ViewModelKey
import com.flamyoad.dagger_android.ui.todo.TodoViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class TodoViewModelsModule {
    @Binds
    @IntoMap
    @ViewModelKey(TodoViewModel::class)
    abstract fun bindTodoViewModel(viewModel: TodoViewModel): ViewModel
}