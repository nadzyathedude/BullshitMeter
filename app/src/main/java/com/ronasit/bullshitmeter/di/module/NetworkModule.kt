package com.ronasit.bullshitmeter.di.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.ronasit.bullshitmeter.BuildConfig
import com.ronasit.bullshitmeter.data.api.ApiInterface
import com.ronasit.bullshitmeter.data.repository.UserRepository
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {

    single<Gson> { GsonBuilder().excludeFieldsWithoutExposeAnnotation().create() }

    single<ApiInterface> {
        val userRepository: UserRepository = get()

        val headerInterceptor = Interceptor { chain ->
            val request = userRepository.token?.let { token ->
                chain.request()
                    .newBuilder()
                    .addHeader("Authorization", "Bearer $token")
                    .build()
            } ?: run { chain.request() }
            chain.proceed(request)
        }

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                this.level = HttpLoggingInterceptor.Level.BODY
            })
            .addInterceptor(headerInterceptor)
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.API_URL)
            .client(okHttpClient)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create(get()))
            .build()
        retrofit.create(ApiInterface::class.java)
    }

}