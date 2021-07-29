package com.ronasit.bullshitmeter.data.repository

import com.ronasit.bullshitmeter.data.module.UpdateRequest

interface UpdateProfileRepository {
    suspend fun updatePhotoUrl(updateRequest: UpdateRequest)

    fun updateName()
}