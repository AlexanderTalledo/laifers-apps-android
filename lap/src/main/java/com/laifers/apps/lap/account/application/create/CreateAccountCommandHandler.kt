package com.laifers.apps.lap.account.application.create

import com.laifers.apps.lap.account.domain.Account
import com.laifers.apps.lap.account.domain.AccountEmailAddress
import com.laifers.apps.lap.account.domain.AccountPassword
import com.laifers.apps.lap.account.domain.AccountUsername
import com.laifers.apps.shared.bus.commands.CommandHandler

class CreateAccountCommandHandler(
    private val creator: AccountCreator
) : CommandHandler<CreateAccountCommand> {

    override fun handle(command: CreateAccountCommand) {
        creator(with(command) {
            Account(
                AccountUsername(username),
                AccountEmailAddress(emailAddress),
                AccountPassword(password)
            )
        })
    }

}