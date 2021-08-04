package com.ronasit.bullshitmeter.ui.main.topics

import android.graphics.Color
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ronasit.bullshitmeter.R
import com.ronasit.bullshitmeter.data.repository.UserRepository
import com.ronasit.bullshitmeter.data.store.Categories
import com.ronasit.bullshitmeter.ui.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.component.inject

class ChooseTopicsViewModel : BaseViewModel() {
    val availableTopics = MutableLiveData<Array<String>>()
    val topicsId = MutableLiveData<Array<Int?>>()
    private val userRepository by inject<UserRepository>()
    fun getTopicsFromServer() {
        try {
            viewModelScope.launch(Dispatchers.IO) {
                val topicsList =
                    userRepository.getTopics().data.map { it.name.toString() }.toTypedArray()
                val ids = userRepository.getTopics().data.map { it.id?.toInt() }.toTypedArray()
                availableTopics.postValue(topicsList)
                topicsId.postValue(ids)
            }
        } catch (e: Exception) {
            exceptionMessage.postValue("Failed getting categories")
        }

    }

    fun onBoardingClick() {

    }
}