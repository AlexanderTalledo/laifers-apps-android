package com.laifers.apps.core.shared.domain.valueobjects

object UsernameMother {

    fun random(): String = MotherCreator.random().name().username()

}