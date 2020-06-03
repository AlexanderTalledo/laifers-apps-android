package com.laifers.apps.core.shared.domain.valueobjects

object IdentifierMother {

    fun random(): String = MotherCreator.random().internet().uuid()

}