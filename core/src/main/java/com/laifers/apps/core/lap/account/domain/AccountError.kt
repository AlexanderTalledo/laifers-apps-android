package com.laifers.apps.core.lap.account.domain

import com.laifers.apps.core.shared.domain.DomainError

abstract class AccountError(message: String? = null) : DomainError(message)

class AccountIdAlreadyExists(
    id: AccountId
) : AccountError("Already exists an account with id: ${id.value}")

class AccountUsernameAlreadyExists(
    username: AccountUsername
) : AccountError("Already exists an account with username: ${username.value}")

class AccountEmailAddressAlreadyExists(
    emailAddress: AccountEmailAddress
) : AccountError("Already exists an account with email address: ${emailAddress.value}")