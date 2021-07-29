package com.ronasit.bullshitmeter.data.api

import com.ronasit.bullshitmeter.data.module.LoginRequest
import com.ronasit.bullshitmeter.data.module.LoginResponse
import com.ronasit.bullshitmeter.data.module.UpdateRequest
import com.ronasit.bullshitmeter.data.store.User
import kotlinx.coroutines.Deferred
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {

    @POST("/login/google")
    fun loginWithGoogle(@Body loginRequest: LoginRequest) : Deferred<LoginResponse>

    @POST("login/facebook")
    fun loginWithFacebook(@Body loginRequest: LoginRequest)

    @POST("/profile")
    fun updateProfile(@Body updateRequest: UpdateRequest) : Deferred<User>

}
