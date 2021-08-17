package com.ronasit.bullshitmeter.data.repository

import com.ronasit.bullshitmeter.data.api.request.UpdateRequest
import com.ronasit.bullshitmeter.data.api.response.CategoriesResponse
import com.ronasit.bullshitmeter.data.store.Languages
import com.ronasit.bullshitmeter.data.store.User


interface UserRepository {
    var user: User?
    var token: String?
    var language: Languages?

    suspend fun updateProfile(updateRequest: UpdateRequest)
    suspend fun getTopics():CategoriesResponse
}