package com.ronasit.bullshitmeter.ui.main.topics

import android.annotation.SuppressLint
import android.graphics.Color
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
    val colors = listOf(R.color.topics_color_blue, R.color.topics_color_red,  R.color.topics_color_green,R.color.topics_color_orange, R.color.topics_color_yellow)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        viewModel.availableTopics.observe(viewLifecycleOwner, { topics ->
            topics.forEach { topics ->
                val chip = Chip(requireContext())
                chip.text = topics.name
                chip.id = topics.id!!

                chip.setTextColor(resources.getColor(R.color.white, context?.theme))
                binding.chipGroup.addView(chip)
                chip.isCheckable = true
                chip.isCheckedIconVisible = false
            }
        })

        binding.chipGroup.setOnCheckedChangeListener { chipGroup, chipId ->
            if (chipGroup.checkedChipId == chipId) {
                val chip = chipGroup.findViewById<Chip>(chipId)
                val index = chipId % 5
                chip.setChipBackgroundColorResource(colors[index])
            }
        }

        viewModel.getTopicsFromServer()
    }
}

