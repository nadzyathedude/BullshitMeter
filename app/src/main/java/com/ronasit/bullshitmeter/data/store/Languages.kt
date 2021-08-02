package com.ronasit.bullshitmeter.data.store

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Languages(
    @SerializedName("id")
    @Expose val id: Int?,
    @SerializedName("code")
    @Expose val code: String?,
)