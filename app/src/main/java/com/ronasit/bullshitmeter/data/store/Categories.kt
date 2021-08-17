package com.ronasit.bullshitmeter.data.store

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Categories(
    @SerializedName("id")
    @Expose val id : Int?,
    @SerializedName("name")
    @Expose val name : String?
)
