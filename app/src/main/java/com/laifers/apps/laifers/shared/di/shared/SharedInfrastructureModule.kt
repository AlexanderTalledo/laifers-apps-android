package com.laifers.apps.laifers.shared.di.shared

import com.laifers.apps.core.shared.domain.bus.commands.CommandBus
import com.laifers.apps.core.shared.infrastructure.bus.commands.InMemoryCommandBus
import dagger.Module
import dagger.Provides

@Module
class SharedInfrastructureModule {

    @Provides
    fun provideCommandBus(): CommandBus = InMemoryCommandBus()

}