package com.flamyoad.dagger_android.ui.main

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.flamyoad.dagger_android.R
import com.flamyoad.dagger_android.common.BaseActivity
import com.flamyoad.dagger_android.databinding.ActivityMainBinding
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class MainActivity : BaseActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    private enum class NavigationFragmentType {
        FIRST,
        SECOND,
        THIRD,
        FOURTH
    }

    private lateinit var binding: ActivityMainBinding

    override fun supportFragmentInjector() = dispatchingAndroidInjector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        if (savedInstanceState == null) {
            showFragment(NavigationFragmentType.FIRST)
        }

        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            val type = when (it.itemId) {
                R.id.first -> NavigationFragmentType.FIRST
                R.id.second -> NavigationFragmentType.SECOND
                R.id.third -> NavigationFragmentType.THIRD
                R.id.fourth -> NavigationFragmentType.FOURTH
                else -> throw IllegalArgumentException("No such type")
            }
            showFragment(type)
            return@setOnNavigationItemSelectedListener true
        }
    }

    override fun onBackPressed() {
        // Pop fragment in the nav backstack if there is any
        val currentNavFragment =
            supportFragmentManager.fragments.first { it.isVisible } as NavHostFragment
        if (currentNavFragment.navController.backQueue.size > 2) {
            currentNavFragment.navController.navigateUp()
        } else {
            super.onBackPressed()
        }
    }

    private fun instantiateFragment(type: NavigationFragmentType): NavHostFragment {
        return when (type) {
            NavigationFragmentType.FIRST -> NavHostFragment.create(R.navigation.todo)
            NavigationFragmentType.SECOND -> NavHostFragment.create(R.navigation.user)
            else -> throw java.lang.IllegalArgumentException()
        }
    }

    private fun showFragment(type: NavigationFragmentType) {
        val transaction = supportFragmentManager.beginTransaction()

        NavigationFragmentType.values()
            .filter { it != type }
            .forEach { it ->
                supportFragmentManager.findFragmentByTag(it.name)?.let { transaction.hide(it) }
            }

        var fragment = supportFragmentManager.findFragmentByTag(type.name)
        if (fragment == null) {
            fragment = instantiateFragment(type)
            transaction.add(R.id.fragmentContainerView, fragment, type.name)
        } else {
            transaction.show(fragment)
        }

        transaction.commit()
    }
}