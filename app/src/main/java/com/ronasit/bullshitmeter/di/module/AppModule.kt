package com.ronasit.bullshitmeter.di.module

import com.ronasit.bullshitmeter.data.store.Preferences
import com.ronasit.bullshitmeter.data.store.PreferencesImpl
import com.ronasit.bullshitmeter.navigation.AppCoordinator
import com.ronasit.bullshitmeter.navigation.AppCoordinatorImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    single<AppCoordinator> { AppCoordinatorImpl() }
    single<Preferences> { PreferencesImpl(androidContext(), get()) }
}

