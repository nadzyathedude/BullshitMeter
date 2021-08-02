package com.ronasit.bullshitmeter.data.repository

import com.ronasit.bullshitmeter.data.module.LanguagesResponse

interface LanguagesRepository {
    suspend fun getLanguages(): LanguagesResponse
}