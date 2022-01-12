package com.flamyoad.dagger_android.ui.login

import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.flamyoad.dagger_android.BR
import com.flamyoad.dagger_android.R
import com.flamyoad.dagger_android.common.BaseActivity
import com.flamyoad.dagger_android.common.ViewModelFactory
import com.flamyoad.dagger_android.databinding.ActivityLoginBinding
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.kotlin.subscribeBy
import javax.inject.Inject

class LoginActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: LoginViewModel by viewModels { viewModelFactory }

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.setVariable(BR.vm, viewModel)

        viewModel.navigateToMain.subscribeBy(onNext = {
            navigator.toMainActivity(this)
        }).addTo(disposeBag)
    }
}