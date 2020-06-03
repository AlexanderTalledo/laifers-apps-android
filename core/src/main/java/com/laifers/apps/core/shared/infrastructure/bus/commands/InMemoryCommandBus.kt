package com.laifers.apps.core.shared.infrastructure.bus.commands

import com.laifers.apps.core.shared.domain.bus.commands.Command
import com.laifers.apps.core.shared.domain.bus.commands.CommandBus

class InMemoryCommandBus : CommandBus {

    override fun dispatch(command: Command) {
//        handler.handle(command)
//        val handler = handlers[command.javaClass]
//        if (handler == null) throw IllegalArgumentException("INVALID HANDLER!!!")
//        else (handler as CommandHandler<Command>).handle(command)
    }

}