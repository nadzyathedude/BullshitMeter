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
        val chipGroup = binding.chipGroup

        val colors = resources.getIntArray(R.array.topics_color)
        viewModel.availableTopics.observe(viewLifecycleOwner, { topics ->
            topics.forEach { topics ->
                val chip = Chip(requireContext())
                chip.text = topics
                chip.setTextColor(resources.getColor(R.color.white, context?.theme))
                chipGroup.addView(chip)
                chipGroup.setOnCheckedChangeListener { _, chipId ->

                    if (chipId % 6 == 0) {
                        chip.setChipBackgroundColorResource(colors[0])
                    }
                    if (chipId % 5 == 0) {
                        chip.setChipBackgroundColorResource(colors[1])
                    }
                    if (chipId % 4 == 0) {
                        chip.setChipBackgroundColorResource(colors[2])
                    }
                    if (chipId % 3 == 0) {
                        chip.setChipBackgroundColorResource(colors[3])
                    }
                    if (chipId % 2 == 0) {
                        chip.setChipBackgroundColorResource(colors[4])
                    }

                }
            }
        })
        viewModel.getTopicsFromServer()

    }

}

