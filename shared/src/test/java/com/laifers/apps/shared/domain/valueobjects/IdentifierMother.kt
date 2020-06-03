package com.laifers.apps.shared.domain.valueobjects

object IdentifierMother {

    fun random(): String = MotherCreator.random().internet().uuid()

}