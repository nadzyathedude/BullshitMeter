package com.ronasit.bullshitmeter.data.repository

import com.ronasit.bullshitmeter.data.api.response.LanguagesResponse

interface LanguagesRepository {
    suspend fun getLanguages(): LanguagesResponse
}