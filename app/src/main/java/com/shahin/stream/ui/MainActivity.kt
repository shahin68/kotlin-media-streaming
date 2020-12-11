package com.shahin.stream.ui

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.shahin.stream.R
import com.shahin.stream.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    lateinit var navHostFragment: NavHostFragment
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        if (::navHostFragment.isInitialized && ::navController.isInitialized) setupBottomNavigationBar()
    }

    private fun setupBottomNavigationBar() {
        binding.navView.setupWithNavController(navController)
        binding.navView.setOnNavigationItemReselectedListener {
            if (navController.currentDestination?.id != binding.navView.selectedItemId) {
                when (it.itemId) {
                    R.id.fragment_home -> navController.popBackStack(
                        R.id.fragment_home,
                        false
                    )
                    else -> {
                        val navOption = NavOptions.Builder().setPopUpTo(
                            binding.navView.selectedItemId,
                            true
                        ).build()
                        navController.navigate(binding.navView.selectedItemId, null, navOption)
                    }
                }
            }
        }
        binding.navView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.fragment_home -> navController.popBackStack(
                    R.id.fragment_home,
                    false
                )
                else -> {
                    navController.navigate(it.itemId)
                }
            }
            true
        }
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {

            }
        }
    }

    override fun onBackPressed() {
        if (binding != null && ::navController.isInitialized) {
            when (navController.currentDestination?.id) {
                R.id.fragment_home -> {
                    if (binding.navView.selectedItemId != R.id.fragment_home) {
                        navController.popBackStack(
                            R.id.fragment_home,
                            false
                        )
                    } else {
                        /**
                         * moves task to recent tasks without loosing last home state
                         */
                        moveTaskToBack(true)
                    }
                }
                else -> {
                    navController.popBackStack(
                        R.id.fragment_home,
                        false
                    )
                }
            }
        }

        // we don't want to trigger default back press
//        super.onBackPressed()
    }
}