package com.laifers.apps.core.shared.domain.bus.commands

interface CommandBus {

    fun dispatch(command: Command)

}