package com.laifers.apps.laifers.shared.di.shared

import com.laifers.apps.lap.account.application.create.CreateAccountCommandHandler
import com.laifers.apps.shared.domain.bus.commands.CommandBus
import com.laifers.apps.shared.infrastructure.bus.commands.InMemoryCommandBus
import dagger.Module
import dagger.Provides

@Module
class SharedInfrastructureModule {

    @Provides
    fun provideCommandBus(): CommandBus = InMemoryCommandBus()

}