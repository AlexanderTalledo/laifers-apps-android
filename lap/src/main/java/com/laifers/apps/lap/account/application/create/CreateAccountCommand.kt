package com.laifers.apps.lap.account.application.create

import com.laifers.apps.shared.domain.bus.commands.Command

data class CreateAccountCommand(
    val username: String,
    val emailAddress: String,
    val password: String
) : Command