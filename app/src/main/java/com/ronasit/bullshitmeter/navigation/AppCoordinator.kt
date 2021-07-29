package com.ronasit.bullshitmeter.navigation

import androidx.navigation.NavController
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.tasks.Task
import com.ronasit.bullshitmeter.data.store.User
import androidx.navigation.Navigator as Navigator

interface AppCoordinator {

    fun startWithNavController(navController: NavController)

    fun startSelectLanguage()

    fun startCreateProfile(user : User)
}