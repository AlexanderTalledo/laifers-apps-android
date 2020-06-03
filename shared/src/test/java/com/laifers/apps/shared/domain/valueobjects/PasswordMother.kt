package com.laifers.apps.shared.domain.valueobjects

object PasswordMother {

    private const val PASSWORD_FORMAT = "A??###?#$%=??z"

    fun random(): String = MotherCreator.random().bothify(PASSWORD_FORMAT)

}