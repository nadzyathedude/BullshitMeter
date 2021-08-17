package com.ronasit.bullshitmeter.ui.main.signin

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.ronasit.bullshitmeter.BuildConfig
import com.ronasit.bullshitmeter.R
import com.ronasit.bullshitmeter.databinding.FragmentSignInBinding
import com.ronasit.bullshitmeter.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignInFragment : BaseFragment<FragmentSignInBinding>() {

    override val layoutId = R.layout.fragment_sign_in
    override val viewModel: SignInViewModel by viewModel()
    lateinit var startForResult: ActivityResultLauncher<Intent>

    private val mGoogleSignInClient: GoogleSignInClient by lazy {
        GoogleSignIn.getClient(
            requireContext(), GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(BuildConfig.DEFAULT_WEB_CLIENT_ID)
                .requestEmail()
                .build()
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        startForResult =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
                val completedTask = GoogleSignIn.getSignedInAccountFromIntent(result.data)
                viewModel.handleSignInResult(completedTask)
            }

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModel

        viewModel.onGoogleSignInClick.observe(viewLifecycleOwner, {
            startForResult.launch(mGoogleSignInClient.signInIntent)
        })
    }
}