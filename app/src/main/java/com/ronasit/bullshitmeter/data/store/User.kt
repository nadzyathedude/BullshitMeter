package com.ronasit.bullshitmeter.data.store

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    @SerializedName("avatar_url")
    @Expose var photoUrl: String?,
    @SerializedName("id")
    @Expose val id: Int?,
    @SerializedName("name")
    @Expose var name: String?,
    @SerializedName("email")
    @Expose var email: String?,
    @SerializedName("role_id")
    @Expose val roleId: Int?
) : Parcelable