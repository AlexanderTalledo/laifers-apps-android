package com.laifers.apps.shared.bus.commands

interface CommandHandler<C : Command> {

    fun handle(command: C)

}