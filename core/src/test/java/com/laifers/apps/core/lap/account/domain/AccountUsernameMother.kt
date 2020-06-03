package com.laifers.apps.core.lap.account.domain

import com.laifers.apps.core.shared.domain.valueobjects.UsernameMother

object AccountUsernameMother {

    internal fun random() = create(UsernameMother.random())

    internal fun create(username: String) = AccountUsername(username)

}