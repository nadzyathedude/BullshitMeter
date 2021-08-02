package com.ronasit.bullshitmeter.ui.main.language

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ronasit.bullshitmeter.data.repository.LanguagesRepository
import com.ronasit.bullshitmeter.data.store.Languages
import com.ronasit.bullshitmeter.ui.base.BaseViewModel
import kotlinx.coroutines.launch
import org.koin.core.component.inject

class SelectLanguageViewModel : BaseViewModel() {

    val liveData = MutableLiveData<List<Languages>>()
    private val languagesRepository by inject<LanguagesRepository>()

    fun getAvailableLanguages() {
        try {
            viewModelScope.launch {
                liveData.postValue(languagesRepository.getLanguages().data)
            }
                 }

            catch(e : Exception){
               exceptionMessage.postValue("Getting  languages failed")
            }

    }
}
