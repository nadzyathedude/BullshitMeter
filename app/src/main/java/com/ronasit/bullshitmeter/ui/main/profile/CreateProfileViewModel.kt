package com.ronasit.bullshitmeter.ui.main.profile

import androidx.lifecycle.viewModelScope
import com.ronasit.bullshitmeter.data.module.UpdateRequest
import com.ronasit.bullshitmeter.data.repository.UserRepository
import com.ronasit.bullshitmeter.ui.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.component.inject

class CreateProfileViewModel : BaseViewModel() {

    val userRepository by inject<UserRepository>()

    fun refreshPhoto(){
         try {
            viewModelScope.launch(Dispatchers.IO) {
                userRepository.updateProfile(UpdateRequest
                    (userRepository.user?.name, userRepository.user?.email ))
            }
        }

        catch (e : Exception)
        {
            exceptionMessage.postValue("refresh photo failed")
        }
    }

    fun onContinueClick() {
        coordinator.startNameChange()
    }
}