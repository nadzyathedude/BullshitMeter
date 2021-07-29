package com.ronasit.bullshitmeter.ui.main.signin

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.ronasit.bullshitmeter.data.module.LoginRequest
import com.ronasit.bullshitmeter.data.repository.AuthRepository
import com.ronasit.bullshitmeter.data.repository.UserRepository
import com.ronasit.bullshitmeter.navigation.AppCoordinator
import com.ronasit.bullshitmeter.ui.base.BaseViewModel
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.core.component.inject

class SignInViewModel : BaseViewModel() {
    private val authRepository by inject<AuthRepository>()
    private val userRepository by inject<UserRepository>()
    override val coordinator by inject<AppCoordinator>()
    val onGoogleSignInClick = MutableLiveData<Unit>()
    fun onGoogleClick() {
        onGoogleSignInClick.postValue(Unit)
    }

    fun handleSignInResult(task: Task<GoogleSignInAccount>) {
        try {
            val account: GoogleSignInAccount? = task.getResult(ApiException::class.java)
            val idToken = account?.idToken
            viewModelScope.launch {
                if (authRepository.loginWithGoogle(LoginRequest(
                        idToken,
                        null))
                ) userRepository.user?.let { coordinator.startCreateProfile(it) }
            }
        } catch (e: Exception) {
            Log.e("SignInViewModel", e.localizedMessage)
        }
    }

    fun onFacebookClick() {
    }

}