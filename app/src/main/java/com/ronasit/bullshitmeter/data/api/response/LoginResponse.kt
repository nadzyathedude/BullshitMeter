package com.ronasit.bullshitmeter.data.api.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.ronasit.bullshitmeter.data.store.User

data class LoginResponse(
    @SerializedName("user")
    @Expose val user: User,
    @SerializedName("token")
    @Expose val token: String
)