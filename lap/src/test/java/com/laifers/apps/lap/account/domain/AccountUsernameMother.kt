package com.laifers.apps.lap.account.domain

import com.laifers.apps.shared.domain.valueobjects.UsernameMother

object AccountUsernameMother {

    internal fun random() = create(UsernameMother.random())

    internal fun create(username: String) = AccountUsername(username)

}