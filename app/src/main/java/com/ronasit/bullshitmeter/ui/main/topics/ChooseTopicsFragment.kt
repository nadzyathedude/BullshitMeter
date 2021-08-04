package com.ronasit.bullshitmeter.ui.main.topics

import android.os.Bundle
import android.view.View
import com.google.android.material.chip.Chip
import com.ronasit.bullshitmeter.R
import com.ronasit.bullshitmeter.databinding.FragmentChooseTopicsBinding
import com.ronasit.bullshitmeter.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class ChooseTopicsFragment : BaseFragment<FragmentChooseTopicsBinding>() {
    override val layoutId = R.layout.fragment_choose_topics
    override val viewModel: ChooseTopicsViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel

        viewModel.availableTopics.observe(viewLifecycleOwner, {
            it.forEach {
                val chip = Chip(requireContext())
                chip.text = it

                binding.chipGroup.addView(chip)
            }
        })
        viewModel.getTopicsFromServer()
    }

}

