package com.laifers.apps.shared.infrastructure.http.retrofit

import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit

abstract class RetrofitClient {

    abstract val baseUrl: String
    abstract val factory: Converter.Factory
    abstract val cache: Cache?

    val retrofit: Retrofit by lazy {
        with(Retrofit.Builder()) {
            baseUrl(baseUrl)
            client(httpClient)
            addConverterFactory(factory)
            build()
        }
    }

    private val httpClient by lazy {
        with(OkHttpClient.Builder()) {
            cache(cache)
            build()
        }
    }

}