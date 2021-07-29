package com.ronasit.bullshitmeter.data.repository

import android.util.Log
import com.ronasit.bullshitmeter.data.api.ApiInterface
import com.ronasit.bullshitmeter.data.module.LoginRequest
import com.ronasit.bullshitmeter.data.module.LoginResponse
import com.ronasit.bullshitmeter.data.store.User

class AuthRepositoryImpl(
    private val apiInterface: ApiInterface,
    private val userRepository: UserRepository,
) : AuthRepository {

    override suspend fun loginWithGoogle(loginRequest: LoginRequest): Boolean {

        return try {
            val loginResponse = apiInterface.loginWithGoogle(loginRequest)
                .await()
            userRepository.user = loginResponse.user
            userRepository.token = loginResponse.token
            true
        } catch (e: Exception) {
            Log.e("AuthRepositoryLogGoogle", e.localizedMessage)
            false
        }

    }

    override suspend fun loginWithFacebook() {

    }

    override suspend fun login() {

    }
}