package com.flamyoad.dagger_android.ui.todo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.library.baseAdapters.BR
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.flamyoad.dagger_android.R
import com.flamyoad.dagger_android.common.BaseFragment
import com.flamyoad.dagger_android.common.ViewModelFactory
import com.flamyoad.dagger_android.databinding.FragmentTodoBinding
import javax.inject.Inject

class TodoFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var todoAdapter: TodoAdapter

    private val viewModel: TodoViewModel by viewModels { viewModelFactory }

    private lateinit var binding: FragmentTodoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_todo, container, false)
        binding.setVariable(BR.vm, viewModel)
        with(binding.todoRecyclerview) {
            adapter = todoAdapter
            layoutManager = LinearLayoutManager(this@TodoFragment.requireContext())
        }
        return binding.root
    }
}