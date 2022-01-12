package com.flamyoad.dagger_android.ui.user

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.flamyoad.dagger_android.BR
import com.flamyoad.dagger_android.R
import com.flamyoad.dagger_android.common.BaseFragment
import com.flamyoad.dagger_android.common.ViewModelFactory
import com.flamyoad.dagger_android.databinding.FragmentUserBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class UserFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: UserViewModel by viewModels { viewModelFactory }

    private lateinit var binding: FragmentUserBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_user, container, false)
        binding.setVariable(BR.vm, viewModel)
        return binding.root
    }
}