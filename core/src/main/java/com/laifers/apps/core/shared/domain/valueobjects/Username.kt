package com.laifers.apps.core.shared.domain.valueobjects

private const val USERNAME_PATTERN = "^[a-zA-Z0-9._]{3,}\$"

abstract class Username(value: String) : StringValueObject(value) {

    override fun isValidValue() = value.isUsername()

}

fun String.isUsername() = USERNAME_PATTERN.toRegex().matches(this)