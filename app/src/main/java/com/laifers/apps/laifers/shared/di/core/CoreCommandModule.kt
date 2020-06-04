package com.laifers.apps.laifers.shared.di.core

import com.laifers.apps.core.lap.account.application.create.CreateAccountCommand
import com.laifers.apps.core.lap.account.application.create.CreateAccountCommandHandler
import com.laifers.apps.core.shared.domain.bus.commands.CommandHandler
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class CoreCommandModule {

    @Binds
    @IntoMap
    @CoreCommandHandlerKey(CreateAccountCommand::class)
    internal abstract fun bindCreateAccountCommandHandler(
        handler: CreateAccountCommandHandler
    ): CommandHandler<*>

}