package com.ronasit.bullshitmeter.data.repository

import com.ronasit.bullshitmeter.data.api.ApiInterface
import com.ronasit.bullshitmeter.data.module.UpdateRequest

class UpdateProfileRepositoryImpl (private val apiInterface: ApiInterface,
                                   private val userRepository: UserRepository): UpdateProfileRepository {

    override suspend  fun updatePhotoUrl(updateRequest: UpdateRequest) {
        val updateResponse = apiInterface.updateProfile(updateRequest)
            .await()
            userRepository.user?.photoUrl = updateResponse.photoUrl
          }

    override fun updateName() {
        TODO("Not yet implemented")
    }
}