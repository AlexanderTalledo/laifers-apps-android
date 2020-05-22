package com.laifers.apps.shared.domain.valueobjects

private const val USERNAME_PATTERN = "^[a-zA-Z0-9._]{3,}\$"

abstract class Username(value: String) : StringValueObject(value) {

    override fun isValidValue() = value.isUsername()

}

private fun String.isUsername() = USERNAME_PATTERN.toRegex().matches(this)