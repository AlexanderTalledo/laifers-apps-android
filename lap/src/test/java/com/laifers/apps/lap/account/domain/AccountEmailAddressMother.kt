package com.laifers.apps.lap.account.domain

import com.laifers.apps.shared.domain.valueobjects.EmailAddressMother

object AccountEmailAddressMother {

    internal fun random() = create(EmailAddressMother.random())

    internal fun create(email: String) = AccountEmailAddress(email)

}