package com.laifers.apps.laifers.shared.di.core

import com.laifers.apps.laifers.shared.di.lap.LapComponent
import com.laifers.apps.core.shared.domain.bus.commands.CommandBus
import dagger.Component

@Component(
    modules = [CoreModule::class],
    dependencies = [LapComponent::class]
)
interface CoreComponent {

    fun commandBus(): CommandBus

    @Component.Builder
    interface Builder {

        fun lapComponent(component: LapComponent): Builder

        fun build(): CoreComponent

    }

}