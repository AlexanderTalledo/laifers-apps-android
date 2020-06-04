package com.laifers.apps.core.shared.infrastructure.bus.commands

import com.laifers.apps.core.shared.domain.bus.commands.Command
import com.laifers.apps.core.shared.domain.bus.commands.CommandBus
import com.laifers.apps.core.shared.domain.bus.commands.CommandHandler

class InMemoryCommandBus(
    private val handlers: MutableMap<Class<out Command>, @JvmSuppressWildcards CommandHandler<*>>
) : CommandBus {

    override fun dispatch(command: Command) {
        val handler = handlers[command.javaClass] ?: throw IllegalArgumentException("INVALID HANDLER!!!")
        (handler as CommandHandler<Command>).handle(command)
    }

}