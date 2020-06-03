package com.laifers.apps.core.shared.domain.valueobjects

object EmailAddressMother {

    fun random(): String = MotherCreator.random().internet().safeEmailAddress()

}