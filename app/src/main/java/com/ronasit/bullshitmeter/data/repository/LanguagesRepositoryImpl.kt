package com.ronasit.bullshitmeter.data.repository

import com.ronasit.bullshitmeter.data.api.ApiInterface
import com.ronasit.bullshitmeter.data.module.LanguagesResponse

class LanguagesRepositoryImpl(private val apiInterface: ApiInterface) : LanguagesRepository {
    override suspend fun getLanguages(): LanguagesResponse {
       return  apiInterface.getLanguages(all = 1)
            .await()
    }
}