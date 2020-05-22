package com.laifers.apps.shared.domain.valueobjects

import com.laifers.apps.shared.domain.InvalidValue
import java.util.*

abstract class StringValueObject(val value: String) {

    init {
        validateValue()
    }

    private fun validateValue() {
        if (!isValidValue()) throw InvalidValue("Invalid ${javaClass.simpleName} value: $value")
    }

    abstract fun isValidValue(): Boolean

    override fun equals(other: Any?): Boolean {
        if (null == other) return false
        if (javaClass != other.javaClass) return false
        if (this === other) return true
        return value == (other as StringValueObject).value
    }

    override fun hashCode() = Objects.hash(value)

    override fun toString() = value

}
