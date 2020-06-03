package com.laifers.apps.core.shared.domain.valueobjects

import com.github.javafaker.Faker

object MotherCreator {

    private val faker by lazy { Faker() }

    fun random() = faker

}