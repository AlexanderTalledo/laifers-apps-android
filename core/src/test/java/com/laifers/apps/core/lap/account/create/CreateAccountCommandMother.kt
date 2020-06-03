package com.laifers.apps.core.lap.account.create

import com.laifers.apps.core.lap.account.application.create.CreateAccountCommand
import com.laifers.apps.core.shared.domain.valueobjects.EmailAddressMother
import com.laifers.apps.core.shared.domain.valueobjects.IdentifierMother
import com.laifers.apps.core.shared.domain.valueobjects.PasswordMother
import com.laifers.apps.core.shared.domain.valueobjects.UsernameMother

object CreateAccountCommandMother {

    internal fun random() = create(
        IdentifierMother.random(),
        UsernameMother.random(),
        EmailAddressMother.random(),
        PasswordMother.random()
    )

    internal fun create(
        id: String,
        username: String,
        emailAddress: String,
        password: String
    ) = CreateAccountCommand(id, username, emailAddress, password)

}