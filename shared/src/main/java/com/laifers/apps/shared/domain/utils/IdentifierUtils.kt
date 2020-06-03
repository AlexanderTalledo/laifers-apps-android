package com.laifers.apps.shared.domain.utils

import java.util.*

object IdentifierUtils {

    fun generate(): String = UUID.randomUUID().toString()

}