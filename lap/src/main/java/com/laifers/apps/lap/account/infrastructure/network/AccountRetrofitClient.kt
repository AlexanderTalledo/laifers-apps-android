package com.laifers.apps.lap.account.infrastructure.network

import com.laifers.apps.shared.infrastructure.http.retrofit.RetrofitClient
import okhttp3.Cache
import retrofit2.Converter
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BASE_URL = "http://localhost:3000/api/accounts/"

class AccountRetrofitClient : RetrofitClient() {

    override val baseUrl = BASE_URL

    override val factory: Converter.Factory = MoshiConverterFactory.create()

    override val cache: Cache? = null

}