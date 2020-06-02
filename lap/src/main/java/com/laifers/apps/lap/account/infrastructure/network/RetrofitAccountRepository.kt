package com.laifers.apps.lap.account.infrastructure.network

import com.laifers.apps.lap.account.domain.Account
import com.laifers.apps.lap.account.domain.AccountRepository

class RetrofitAccountRepository(private val service: RetrofitAccountService) : AccountRepository {

    override fun create(account: Account) {
        with(account) {
            service.create(
                "",
                RetrofitAccountService.Request(username.value, emailAddress.value, password.value)
            )
        }
    }

}