package com.ronasit.bullshitmeter.ui.base

import androidx.lifecycle.ViewModel
import com.ronasit.bullshitmeter.navigation.AppCoordinator
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

abstract class BaseViewModel: ViewModel(), KoinComponent {

    protected open val coordinator by inject<AppCoordinator>()
}