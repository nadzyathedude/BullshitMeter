package com.ronasit.bullshitmeter.di.module

import com.ronasit.bullshitmeter.data.repository.*
import org.koin.dsl.module

val repositoryModule = module {
    factory<AuthRepository> { AuthRepositoryImpl(get(), get()) }
    single<UserRepository> { UserRepositoryImpl(get(), get()) }
    single<UpdateProfileRepository> {UpdateProfileRepositoryImpl(get(), get())}
}