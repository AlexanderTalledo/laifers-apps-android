package com.laifers.apps.shared.domain.bus.commands

interface CommandHandler<C : Command> {

    fun handle(command: C)

}