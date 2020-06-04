package com.laifers.apps.laifers.shared.di.core

import com.laifers.apps.core.shared.domain.bus.commands.Command
import com.laifers.apps.core.shared.domain.bus.commands.CommandBus
import com.laifers.apps.core.shared.domain.bus.commands.CommandHandler
import com.laifers.apps.core.shared.infrastructure.bus.commands.InMemoryCommandBus
import dagger.Module
import dagger.Provides
import javax.inject.Provider

@Module(includes = [CoreCommandModule::class])
class CoreModule {

    @Provides
    fun provideCommandBus(
        handlers: MutableMap<Class<out Command>, @JvmSuppressWildcards CommandHandler<*>>
    ): CommandBus = InMemoryCommandBus(handlers)


}
