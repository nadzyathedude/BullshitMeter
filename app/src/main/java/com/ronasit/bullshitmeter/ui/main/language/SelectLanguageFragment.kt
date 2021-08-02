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
        val languagePicker = binding.pickerLanguage

        viewModel.liveData.observe(viewLifecycleOwner, {
            languagePicker.maxValue = 13
            languagePicker.minValue = 0
            languagePicker.displayedValues = it.map { it.code }.toTypedArray()
        })

        viewModel.getAvailableLanguages()
    }
}