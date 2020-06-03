package com.laifers.apps.laifers.shared.di.shared

import com.laifers.apps.core.shared.domain.bus.commands.CommandBus
import dagger.Component

@Component(
    modules = [SharedInfrastructureModule::class]
)
interface SharedComponent {

    fun commandBus(): CommandBus

    @Component.Builder
    interface Builder {

        fun build(): SharedComponent

    }

}