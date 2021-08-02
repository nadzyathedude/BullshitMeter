package com.ronasit.bullshitmeter.navigation

import androidx.navigation.NavController
import com.ronasit.bullshitmeter.data.store.User

interface AppCoordinator {

    fun startWithNavController(navController: NavController)

    fun startSelectLanguage()

    fun startCreateProfile(user : User)

    fun startNameChange()
}