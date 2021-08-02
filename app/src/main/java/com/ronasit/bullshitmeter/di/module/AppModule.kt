package com.ronasit.bullshitmeter.di.module

import com.ronasit.bullshitmeter.navigation.AppCoordinator
import com.ronasit.bullshitmeter.navigation.AppCoordinatorImpl
import org.koin.dsl.module

val appModule = module {
    single<AppCoordinator> { AppCoordinatorImpl() }

}

