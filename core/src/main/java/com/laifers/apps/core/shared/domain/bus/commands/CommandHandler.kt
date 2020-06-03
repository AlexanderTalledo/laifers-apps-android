package com.laifers.apps.core.shared.domain.bus.commands

interface CommandHandler<C : Command> {

    fun handle(command: C)

}