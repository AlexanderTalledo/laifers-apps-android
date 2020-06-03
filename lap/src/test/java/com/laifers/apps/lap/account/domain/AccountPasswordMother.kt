package com.laifers.apps.lap.account.domain

import com.laifers.apps.shared.domain.valueobjects.PasswordMother

object AccountPasswordMother {

    internal fun random() = create(PasswordMother.random())

    internal fun create(password: String) = AccountPassword(password)

}