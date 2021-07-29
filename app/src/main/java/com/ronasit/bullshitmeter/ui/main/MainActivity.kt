package com.ronasit.bullshitmeter.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.ronasit.bullshitmeter.R
import com.ronasit.bullshitmeter.databinding.ActivityMainBinding
import com.ronasit.bullshitmeter.navigation.AppCoordinator
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    val mainActivityViewModel: MainActivityViewModel by viewModel()
    private val navHost by lazy {
        supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
    }
    private val navigationController by lazy {
        navHost.navController
    }

    private val coordinator by inject<AppCoordinator>()

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        coordinator.startWithNavController(navigationController)

        val appBarConfiguration = AppBarConfiguration(navigationController.graph)
        AppBarConfiguration.Builder(R.layout.fragment_sign_in).build()

        NavigationUI.setupWithNavController(
            binding.toolbar,
            navigationController,
            appBarConfiguration
        )
    }
}

