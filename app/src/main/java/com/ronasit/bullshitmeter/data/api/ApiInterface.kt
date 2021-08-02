package com.ronasit.bullshitmeter.data.api

import com.ronasit.bullshitmeter.data.api.request.LoginRequest
import com.ronasit.bullshitmeter.data.api.request.UpdateRequest
import com.ronasit.bullshitmeter.data.api.response.LanguagesResponse
import com.ronasit.bullshitmeter.data.api.response.LoginResponse
import com.ronasit.bullshitmeter.data.store.User
import kotlinx.coroutines.Deferred
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiInterface {

    @POST("/login/google")
    fun loginWithGoogle(@Body loginRequest: LoginRequest): Deferred<LoginResponse>

    @POST("login/facebook")
    fun loginWithFacebook(@Body loginRequest: LoginRequest)

    @POST("/profile")
    fun updateProfile(@Body updateRequest: UpdateRequest): Deferred<User>

    @GET("/languages")
    fun getLanguages(
        @Query("all") all: Int,
    ): Deferred<LanguagesResponse>

}
