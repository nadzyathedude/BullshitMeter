package com.ronasit.bullshitmeter.data.repository

import com.ronasit.bullshitmeter.data.api.ApiInterface
import com.ronasit.bullshitmeter.data.api.request.UpdateRequest
import com.ronasit.bullshitmeter.data.api.response.CategoriesResponse
import com.ronasit.bullshitmeter.data.store.Languages
import com.ronasit.bullshitmeter.data.store.Preferences
import com.ronasit.bullshitmeter.data.store.User

class UserRepositoryImpl(
    private val apiInterface: ApiInterface,
    private val preferences: Preferences
) : UserRepository {

    override var user: User?
        get() = preferences.user
        set(value) {
            preferences.user = value
        }
    override var token: String?
        get() = preferences.token
        set(value) {
            preferences.token = value
        }
    override var language: Languages?
        get() = preferences.language
        set(value) {
            preferences.language = value
        }

    override suspend fun updateProfile(updateRequest: UpdateRequest) {
        val updateResponse = apiInterface.updateProfile(updateRequest)
            .await()

        with(user) {
            this?.photoUrl = updateResponse.photoUrl
            user = this
        }
    }

    override suspend fun getTopics(): CategoriesResponse {
        return apiInterface.getCategories(all = 1)
            .await()
    }

}