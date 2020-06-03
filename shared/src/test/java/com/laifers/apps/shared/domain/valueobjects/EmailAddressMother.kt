package com.laifers.apps.shared.domain.valueobjects

object EmailAddressMother {

    fun random(): String = MotherCreator.random().internet().safeEmailAddress()

}