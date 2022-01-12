package com.flamyoad.dagger_android.ui.todo

import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.flamyoad.dagger_android.R

object TodoBindingAdapter {
    @JvmStatic
    @BindingAdapter("todoItems")
    fun loadItems(recyclerView: RecyclerView, todoList: List<Todo>?) {
        (recyclerView.adapter as TodoAdapter).list = todoList ?: emptyList()
    }

    @JvmStatic
    @BindingAdapter("todoDone")
    fun loadLogo(imageView: ImageView, isDone: Boolean) {
        val drawableId = if (isDone) {
            R.drawable.ic_baseline_done_all_24
        } else {
            R.drawable.ic_baseline_done_all_24_grey
        }
        Glide.with(imageView)
            .load(ContextCompat.getDrawable(imageView.context, drawableId))
            .into(imageView)
    }

}