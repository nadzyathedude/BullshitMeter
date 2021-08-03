package com.ronasit.bullshitmeter.data.api.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.ronasit.bullshitmeter.data.store.Categories

data class CategoriesResponse(
    @SerializedName("data")
    @Expose val data : List<Categories>
)
