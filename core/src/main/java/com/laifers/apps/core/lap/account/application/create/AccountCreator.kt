package com.laifers.apps.core.lap.account.application.create

import com.laifers.apps.core.lap.account.domain.Account
import com.laifers.apps.core.lap.account.domain.AccountRepository

class AccountCreator(private val repository: AccountRepository) {

    internal operator fun invoke(account: Account) {
        repository.create(account)
    }

}