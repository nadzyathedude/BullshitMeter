package com.ronasit.bullshitmeter.ui.main.language

import android.os.Bundle
import android.view.View
import com.ronasit.bullshitmeter.R
import com.ronasit.bullshitmeter.databinding.FragmentSelectLanguageBinding
import com.ronasit.bullshitmeter.ui.base.BaseFragment
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class SelectLanguageFragment : BaseFragment<FragmentSelectLanguageBinding>() {

    override val layoutId = R.layout.fragment_select_language
    override val viewModel: SelectLanguageViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.viewModel = viewModel
        val locales = Locale.getAvailableLocales()
        val localCountries = ArrayList<String>()

        val languagePicker = binding?.pickerLanguage
        for (l in locales) {
            localCountries.add(l.displayLanguage.toString())
        }
        val languages = localCountries.toArray(arrayOfNulls<String>(localCountries.size))
        languagePicker?.maxValue = 15
        languagePicker?.minValue = 0
        languagePicker?.displayedValues = languages
    }
}