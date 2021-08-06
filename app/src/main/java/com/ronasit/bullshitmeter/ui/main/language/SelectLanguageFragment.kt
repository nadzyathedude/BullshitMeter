package com.ronasit.bullshitmeter.ui.main.language

import android.os.Bundle
import android.view.View
import com.ronasit.bullshitmeter.R
import com.ronasit.bullshitmeter.databinding.FragmentSelectLanguageBinding
import com.ronasit.bullshitmeter.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class SelectLanguageFragment : BaseFragment<FragmentSelectLanguageBinding>() {

    override val layoutId = R.layout.fragment_select_language
    override val viewModel: SelectLanguageViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.buttonContinue.isEnabled = false
        viewModel.availableLocales.observe(viewLifecycleOwner, { data ->
            with(binding) {
                pickerLanguage.visibility = View.VISIBLE
                binding.progressBar.visibility = View.INVISIBLE
                pickerLanguage.minValue = 0
                pickerLanguage.maxValue = data.size - 1
                pickerLanguage.displayedValues = data.map { it.first }.toTypedArray()
                pickerLanguage.setOnValueChangedListener { _, _, newVal ->
                    this@SelectLanguageFragment.viewModel.currentSelectedLocaleIndex = newVal
                }
                buttonContinue.isEnabled = data.isEmpty().not()
            }
        })

        viewModel.getAvailableLanguages()
    }
}