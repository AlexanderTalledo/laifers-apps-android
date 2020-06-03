package com.laifers.apps.core.lap.account.domain

import com.laifers.apps.core.shared.domain.valueobjects.IdentifierMother

object AccountIdMother {

    internal fun random() = create(IdentifierMother.random())

    internal fun create(id: String) = AccountId(id)

}