package com.laifers.apps.shared.domain.valueobjects

import java.util.*

abstract class Identifier(value: String) : StringValueObject(value) {

    override fun isValidValue() = try {
        UUID.fromString(value)
        true
    } catch (exception: IllegalArgumentException) {
        false
    }

}