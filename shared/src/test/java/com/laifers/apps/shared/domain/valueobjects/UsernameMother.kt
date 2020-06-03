package com.laifers.apps.shared.domain.valueobjects

object UsernameMother {

    fun random(): String = MotherCreator.random().name().username()

}