package com.ronasit.bullshitmeter.ui.main.signin

import androidx.lifecycle.viewModelScope
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.ronasit.bullshitmeter.data.api.request.LoginRequest
import com.ronasit.bullshitmeter.data.repository.AuthRepository
import com.ronasit.bullshitmeter.data.repository.UserRepository
import com.ronasit.bullshitmeter.ui.base.BaseViewModel
import com.ronasit.bullshitmeter.ui.base.SingleLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.core.component.inject

class SignInViewModel : BaseViewModel() {

    val onGoogleSignInClick = SingleLiveData<Unit>()

    private val authRepository by inject<AuthRepository>()
    private val userRepository by inject<UserRepository>()

    fun onGoogleClick() {
        onGoogleSignInClick.postValue(Unit)
    }

    fun handleSignInResult(task: Task<GoogleSignInAccount>) {
        try {
            val account: GoogleSignInAccount? = task.getResult(ApiException::class.java)
            val idToken = account?.idToken
            viewModelScope.launch(Dispatchers.IO) {
                if (authRepository.loginWithGoogle(
                        LoginRequest(
                            idToken,
                            null
                        )
                    )
                ) userRepository.user?.let {
                    GlobalScope.launch(Dispatchers.Main) {
                        coordinator.startCreateProfile(it)
                    }
                }
            }
        } catch (e: Exception) {
            exceptionMessage.postValue("Sign in with google failed")
        }
    }

    fun onFacebookClick() {
    }
}