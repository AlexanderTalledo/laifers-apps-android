package com.laifers.apps.lap.account.domain

data class Account(
    val username: AccountUsername,
    val emailAddress: AccountEmailAddress,
    val password: AccountPassword
)