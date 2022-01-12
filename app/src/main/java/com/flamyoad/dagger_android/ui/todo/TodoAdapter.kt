package com.flamyoad.dagger_android.ui.todo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.flamyoad.dagger_android.R
import com.flamyoad.dagger_android.databinding.TodoListItemBinding

class TodoAdapter : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    var list: List<Todo> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class TodoViewHolder(private val binding: TodoListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(todo: Todo) {
            binding.item = todo
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val binding =
            DataBindingUtil.inflate<TodoListItemBinding>(
                LayoutInflater.from(parent.context),
                R.layout.todo_list_item,
                parent,
                false
            )
        return TodoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        if (position != RecyclerView.NO_POSITION) {
            holder.bind(list[position])
        }
    }

    override fun getItemCount(): Int = list.size
}