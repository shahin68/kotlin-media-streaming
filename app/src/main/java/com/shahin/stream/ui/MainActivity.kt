package com.shahin.stream.ui

import android.os.Bundle
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.shahin.stream.R
import com.shahin.stream.databinding.ActivityMainBinding

class MainActivity : BaseActivity(R.layout.activity_main) {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setupBottomNavigationBar()
    }

    private fun setupBottomNavigationBar() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        binding.navView.setupWithNavController(navController)
        binding.navView.setOnNavigationItemReselectedListener {
            if (navController.currentDestination?.id != binding.navView.selectedItemId) {
                when (it.itemId) {
                    R.id.fragment_home -> findNavController(R.id.host_fragment).popBackStack(
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
                R.id.fragment_home -> findNavController(R.id.host_fragment).popBackStack(
                    R.id.fragment_home,
                    false
                )
                else -> {
                    findNavController(R.id.host_fragment).navigate(it.itemId)
                }
            }
            true
        }
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {

            }
        }
    }
}