package com.laifers.apps.lap.account.domain

import com.laifers.apps.shared.domain.valueobjects.IdentifierMother

object AccountIdMother {

    internal fun random() = create(IdentifierMother.random())

    internal fun create(id: String) = AccountId(id)

}