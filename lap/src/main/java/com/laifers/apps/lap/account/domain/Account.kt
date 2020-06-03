package com.laifers.apps.lap.account.domain

data class Account(
    val id: AccountId,
    val username: AccountUsername,
    val emailAddress: AccountEmailAddress,
    val password: AccountPassword
)