package com.laifers.apps.core.lap.account.application.create

import com.laifers.apps.core.shared.domain.bus.commands.Command
import com.laifers.apps.core.shared.domain.utils.IdentifierUtils

data class CreateAccountCommand(
    val id: String = IdentifierUtils.generate(),
    val username: String,
    val emailAddress: String,
    val password: String
) : Command