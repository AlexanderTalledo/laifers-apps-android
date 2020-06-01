package com.laifers.apps.shared.domain.valueobjects

private const val PASSWORD_PATTERN =
    "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#\$%^&+=])(?=\\S+\$).{8,}\$"

abstract class Password(value: String) : StringValueObject(value) {

    override fun isValidValue() = value.isPassword()

}

fun String.isPassword() = PASSWORD_PATTERN.toRegex().matches(this)