package com.ronasit.bullshitmeter.ui.main.profile

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.bumptech.glide.Glide
import com.github.dhaval2404.imagepicker.ImagePicker
import com.ronasit.bullshitmeter.R
import com.ronasit.bullshitmeter.databinding.FragmentCreateProfileBinding
import com.ronasit.bullshitmeter.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class CreateProfileFragment : BaseFragment<FragmentCreateProfileBinding>() {

    override val layoutId = R.layout.fragment_create_profile
    override val viewModel: CreateProfileViewModel by viewModel()

    lateinit var startForProfileImageResult: ActivityResultLauncher<Intent>
    lateinit var fileUri: Uri

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        startForProfileImageResult =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
                val resultCode = result.resultCode
                val data = result.data
                if (resultCode == Activity.RESULT_OK) {
                    data?.data?.let { uri ->
                        fileUri = uri
                        viewModel.refreshPhoto()

                        Glide
                            .with(this)
                            .load(fileUri)
                            .circleCrop()
                            .placeholder(R.drawable.profile_pic)
                            .into(binding.imageViewProfile)
                    }
                }
            }
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModel

        viewModel.userRepository.user?.photoUrl?.let { photoUrl ->
            Glide
                .with(this)
                .load(photoUrl)
                .circleCrop()
                .placeholder(R.drawable.profile_pic)
                .into(binding.imageViewProfile)
        }

        binding.imageButtonCamera.setOnClickListener {
            ImagePicker.with(this)
                .maxResultSize(5120, 5120)
                .createIntent { intent ->
                    startForProfileImageResult.launch(intent)
                }
        }

        binding.textViewName.text = viewModel.userRepository.user?.name ?: ""
    }
}