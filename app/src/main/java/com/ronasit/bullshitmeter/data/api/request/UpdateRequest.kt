package com.ronasit.bullshitmeter.data.api.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UpdateRequest(
    @SerializedName("name")
    @Expose var name: String?,
    @SerializedName("email")
    @Expose var email: String?,
)