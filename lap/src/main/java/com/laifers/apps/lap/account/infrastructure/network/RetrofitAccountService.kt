package com.laifers.apps.lap.account.infrastructure.network

import retrofit2.http.Body
import retrofit2.http.PUT
import retrofit2.http.Path

private const val PATH_VALUE_ID = "id"
private const val PATH = "/{${PATH_VALUE_ID}}"

interface RetrofitAccountService {

    @PUT(PATH)
    fun create(@Path(value = PATH_VALUE_ID) id: String, @Body request: Request)

    data class Request(
        val username: String,
        val emailAddress: String,
        val password: String
    )

}