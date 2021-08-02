package com.ronasit.bullshitmeter.navigation

import androidx.navigation.NavController
import com.ronasit.bullshitmeter.data.store.User
import com.ronasit.bullshitmeter.ui.main.profile.CreateProfileFragmentDirections
import com.ronasit.bullshitmeter.ui.main.signin.SignInFragmentDirections

class AppCoordinatorImpl : AppCoordinator {
    private lateinit var nav: NavController

    override fun startWithNavController(nav: NavController) {
        this.nav = nav
    }

    override fun startSelectLanguage() {
        // nav.navigate(CreateProfileFragmentDirections.actionCreateProfileToLanguage())
    }

    override fun startCreateProfile(user: User) {
        nav.navigate(SignInFragmentDirections.actionSigninToCreateProfile())
    }

    override fun startNameChange() {
        nav.navigate(CreateProfileFragmentDirections.actionCreateProfileToChangeName())
    }
}

