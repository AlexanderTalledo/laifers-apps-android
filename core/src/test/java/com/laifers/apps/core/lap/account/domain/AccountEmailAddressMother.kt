package com.laifers.apps.core.lap.account.domain

import com.laifers.apps.core.shared.domain.valueobjects.EmailAddressMother

object AccountEmailAddressMother {

    internal fun random() = create(EmailAddressMother.random())

    internal fun create(email: String) = AccountEmailAddress(email)

}