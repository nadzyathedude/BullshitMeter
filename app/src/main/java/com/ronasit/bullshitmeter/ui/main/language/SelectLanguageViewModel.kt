package com.ronasit.bullshitmeter.ui.main.language

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ronasit.bullshitmeter.data.repository.LanguagesRepository
import com.ronasit.bullshitmeter.data.repository.UserRepository
import com.ronasit.bullshitmeter.data.store.Languages
import com.ronasit.bullshitmeter.ui.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.core.component.inject
import java.util.*

class SelectLanguageViewModel : BaseViewModel() {

    val availableLocales = MutableLiveData<List<Pair<String, Languages>>>()
    var currentSelectedLocaleIndex = 0
    private val languagesRepository by inject<LanguagesRepository>()
    private val userRepository by inject<UserRepository>()

    fun getAvailableLanguages() {
        try {
            viewModelScope.launch(Dispatchers.IO) {
                val locales = languagesRepository.getLanguages().data
                val availableLanguages = Locale.getAvailableLocales().filter { locale ->
                    locales.any { locale.language == it.code }
                }.distinctBy { it.language }

                val data = availableLanguages.map { locale ->
                    Pair<String, Languages>(
                        locale.displayLanguage,
                        locales.first { locale.language == it.code })
                }
                availableLocales.postValue(data)
            }
        } catch (e: Exception) {
            exceptionMessage.postValue("Getting  languages failed")
        }
    }

    fun onContinueClick() {
        userRepository.language = availableLocales.value?.get(currentSelectedLocaleIndex)?.second
        GlobalScope.launch(Dispatchers.Main) { coordinator.startTopicsChoose() }
    }
}

