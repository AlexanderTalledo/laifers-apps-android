package com.laifers.apps.lap.account.infrastructure.network

import com.laifers.apps.lap.account.domain.Account
import com.laifers.apps.lap.account.domain.AccountRepository

class RetrofitAccountRepository : AccountRepository {

    override fun create(account: Account) {
        println(account)
    }

}