package com.laifers.apps.core.lap.account.infrastructure.network

import com.laifers.apps.core.lap.account.domain.Account
import com.laifers.apps.core.lap.account.domain.AccountRepository

class RetrofitAccountRepository(private val service: RetrofitAccountService) : AccountRepository {

    override fun create(account: Account) {
        with(account) {
            service.create(id.value, requestToCreate(this)).execute()
        }
    }

    private fun requestToCreate(account: Account) = with(account) {
        RetrofitAccountService.Request(
            username.value,
            emailAddress.value,
            password.value
        )
    }

}