package com.ronasit.bullshitmeter.ui.main.profile

import androidx.lifecycle.viewModelScope
import com.ronasit.bullshitmeter.data.module.UpdateRequest
import com.ronasit.bullshitmeter.data.repository.UpdateProfileRepository
import com.ronasit.bullshitmeter.data.repository.UserRepository
import com.ronasit.bullshitmeter.data.store.User
import com.ronasit.bullshitmeter.ui.base.BaseViewModel
import kotlinx.coroutines.launch
import org.koin.core.component.inject

class CreateProfileViewModel : BaseViewModel() {

    val userRepository by inject<UserRepository>()
    val user = userRepository.user
    private val updateProfileRepository by inject  <UpdateProfileRepository>()


    fun refreshPhoto(){
            viewModelScope.launch {
                updateProfileRepository.updatePhotoUrl(UpdateRequest
                    (userRepository.user?.name, userRepository.user?.email ))
            }
    }

}