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
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.github.dhaval2404.imagepicker.ImagePicker
import com.ronasit.bullshitmeter.R
import com.ronasit.bullshitmeter.data.repository.UserRepositoryImpl
import com.ronasit.bullshitmeter.data.store.User
import com.ronasit.bullshitmeter.databinding.FragmentCreateProfileBinding
import com.ronasit.bullshitmeter.navigation.AppCoordinator
import com.ronasit.bullshitmeter.ui.base.BaseFragment
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.inject

class CreateProfileFragment : BaseFragment<FragmentCreateProfileBinding>() {
    override val layoutId = R.layout.fragment_create_profile
    override val viewModel: CreateProfileViewModel by viewModel()
    lateinit var startForProfileImageResult: ActivityResultLauncher<Intent>
    lateinit var fileUri: Uri
    private val coordinator by inject<AppCoordinator>()
    private val createProfileViewModel by inject<CreateProfileViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.viewModel = viewModel
        binding?.let {
            Glide
                .with(this)
                .load(createProfileViewModel.user?.photoUrl)
                .circleCrop()
                .placeholder(R.drawable.profile_pic)
                .into(it.imageViewProfile)
        }
        binding?.imageButtonCamera?.setOnClickListener {
            ImagePicker.with(this)
                .maxResultSize(5120, 5120)
                .createIntent { intent ->
                    startForProfileImageResult.launch(intent)
                }
        }
        binding?.textViewName?.text = createProfileViewModel.user?.name
        binding?.buttonContinue?.setOnClickListener {
            coordinator.startSelectLanguage()
        }
    }

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
                    data?.data.let {
                        fileUri = it!!
                        viewModel.refreshPhoto()
                    }
                    binding?.let {
                        Glide
                            .with(this)
                            .load(fileUri)
                            .circleCrop()
                            .placeholder(R.drawable.profile_pic)
                            .into(it.imageViewProfile)
                    }

                }

            }
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}