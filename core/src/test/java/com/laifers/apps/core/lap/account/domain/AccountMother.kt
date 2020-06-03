package com.laifers.apps.core.lap.account.domain

import com.laifers.apps.core.lap.account.application.create.CreateAccountCommand

object AccountMother {

    fun from(command: CreateAccountCommand) = with(command) {
        create(
            AccountId(id),
            AccountUsername(username),
            AccountEmailAddress(emailAddress)
        )
    }

    fun random() = create(
        AccountIdMother.random(),
        AccountUsernameMother.random(),
        AccountEmailAddressMother.random(),
        AccountPasswordMother.random()
    )

    fun create(
        id: AccountId,
        username: AccountUsername,
        emailAddress: AccountEmailAddress,
        password: AccountPassword = AccountPasswordMother.random()
    ) = Account(id, username, emailAddress, password)

}