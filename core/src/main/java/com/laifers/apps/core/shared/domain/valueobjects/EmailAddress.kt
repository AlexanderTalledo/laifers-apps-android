package com.laifers.apps.core.shared.domain.valueobjects

import org.apache.commons.validator.routines.EmailValidator

abstract class EmailAddress(value: String) : StringValueObject(value) {

    override fun isValidValue() = value.isEmailAddress()

}

fun String.isEmailAddress() = EmailValidator.getInstance().isValid(this)