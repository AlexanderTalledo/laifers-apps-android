package com.laifers.apps.core.lap.account.domain

import com.laifers.apps.core.shared.domain.valueobjects.PasswordMother

object AccountPasswordMother {

    internal fun random() = create(PasswordMother.random())

    internal fun create(password: String) = AccountPassword(password)

}