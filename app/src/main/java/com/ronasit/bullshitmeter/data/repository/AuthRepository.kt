package com.ronasit.bullshitmeter.data.repository

import com.ronasit.bullshitmeter.data.module.LoginRequest
import com.ronasit.bullshitmeter.data.store.User

interface AuthRepository {
    suspend fun loginWithGoogle(loginRequest: LoginRequest) : Boolean

    suspend fun loginWithFacebook()

    suspend fun login()

}