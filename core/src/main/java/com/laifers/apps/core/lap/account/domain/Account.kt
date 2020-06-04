package com.laifers.apps.core.lap.account.domain

import java.util.*

data class Account(
    val id: AccountId,
    val username: AccountUsername,
    val emailAddress: AccountEmailAddress,
    val password: AccountPassword
) {

    override fun equals(other: Any?): Boolean {
        if (null == other) return false
        if (this.javaClass != other.javaClass) return false
        if (this === other) return true
        return with(other as Account) {
            id == this.id &&
                    username == this.username &&
                    emailAddress == this.emailAddress &&
                    password == this.password
        }
    }

    override fun hashCode() = Objects.hash(id, username, emailAddress, password)

}