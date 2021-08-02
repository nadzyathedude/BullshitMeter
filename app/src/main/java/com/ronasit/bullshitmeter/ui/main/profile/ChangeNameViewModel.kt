package com.ronasit.bullshitmeter.ui.main.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ronasit.bullshitmeter.data.module.UpdateRequest
import com.ronasit.bullshitmeter.data.repository.UserRepository
import com.ronasit.bullshitmeter.ui.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.component.inject

class ChangeNameViewModel : BaseViewModel() {

    val userName = MutableLiveData<String>()
    val email = MutableLiveData<String>()

    private val userRepository by inject<UserRepository>()

    init {
        userName.value = userRepository.user?.name ?: ""
        email.value = userRepository.user?.email ?: ""
    }

    fun onContinueClick(): Boolean {
        return try {
            viewModelScope.launch (Dispatchers.IO) {
                val request = UpdateRequest(
                    userName.value,
                    email.value
                )
                userRepository.updateProfile(request)
            }
            true
        } catch (e: Exception) {
            exceptionMessage.postValue("Update name and email failed")
            false
        }

    }
}