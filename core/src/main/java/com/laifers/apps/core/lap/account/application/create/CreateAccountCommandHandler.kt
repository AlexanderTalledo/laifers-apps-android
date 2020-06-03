package com.laifers.apps.core.lap.account.application.create

import com.laifers.apps.core.lap.account.domain.*
import com.laifers.apps.core.shared.domain.bus.commands.CommandHandler

class CreateAccountCommandHandler(
    private val creator: AccountCreator
) : CommandHandler<CreateAccountCommand> {

    override fun handle(command: CreateAccountCommand) {
        creator(with(command) {
            Account(
                AccountId(id),
                AccountUsername(username),
                AccountEmailAddress(emailAddress),
                AccountPassword(password)
            )
        })
    }

}