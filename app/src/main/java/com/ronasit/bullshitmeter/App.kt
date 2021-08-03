package com.ronasit.bullshitmeter

import android.app.Application
import com.ronasit.bullshitmeter.di.module.appModule
import com.ronasit.bullshitmeter.di.module.networkModule
import com.ronasit.bullshitmeter.di.module.repositoryModule
import com.ronasit.bullshitmeter.di.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(appModule, viewModelModule, repositoryModule, networkModule )
        }
    }
}