package com.ronasit.bullshitmeter.ui.main.profile

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.ronasit.bullshitmeter.R
import com.ronasit.bullshitmeter.databinding.FragmentNameChangeBinding
import com.ronasit.bullshitmeter.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class ChangeNameFragment : BaseFragment<FragmentNameChangeBinding>() {
    override val layoutId: Int = R.layout.fragment_name_change
    override val viewModel: ChangeNameViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel

        binding.textViewEditName.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                binding.imageViewEditName.setColorFilter(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.edit_name_button_active_color
                    )
                )
            } else {
                binding.imageViewEditName.setColorFilter(
                    ContextCompat.getColor(
                        requireContext(),
                        (R.color.edit_name_button_normal_color)
                    )
                )
            }
        }
        binding.textViewEditEmail.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                binding.imageViewEditEmail.setColorFilter(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.edit_name_button_active_color
                    )
                )
            } else {
                binding.imageViewEditEmail.setColorFilter(
                    ContextCompat.getColor(
                        requireContext(),
                        (R.color.edit_name_button_normal_color)
                    )
                )
            }
        }
    }

}