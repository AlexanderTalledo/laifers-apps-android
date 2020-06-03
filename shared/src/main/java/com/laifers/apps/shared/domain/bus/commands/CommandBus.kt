package com.laifers.apps.shared.domain.bus.commands

interface CommandBus {

    fun dispatch(command: Command)

}