package com.ronasit.bullshitmeter.data.module

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("google_access_token")
    @Expose
    var googleAccessToken : String?,

    @SerializedName("facebook_access_token")
    @Expose
    val facebookAccessToken: String?)

