package com.ronasit.bullshitmeter.di.module

import com.ronasit.bullshitmeter.ui.main.MainActivityViewModel
import com.ronasit.bullshitmeter.ui.main.language.SelectLanguageViewModel
import com.ronasit.bullshitmeter.ui.main.profile.ChangeNameViewModel
import com.ronasit.bullshitmeter.ui.main.profile.CreateProfileViewModel
import com.ronasit.bullshitmeter.ui.main.signin.SignInViewModel
import com.ronasit.bullshitmeter.ui.main.topics.ChooseTopicsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SignInViewModel() }
    viewModel { MainActivityViewModel() }
    viewModel { SelectLanguageViewModel() }
    viewModel { CreateProfileViewModel() }
    viewModel { ChangeNameViewModel() }
    viewModel { ChooseTopicsViewModel() }
}