package com.laifers.apps.laifers.shared.di.lap

import com.laifers.apps.core.lap.account.application.create.CreateAccountCommandHandler
import dagger.Component

@Component(
    modules = [
        LapApplicationModule::class,
        LapInfrastructureModule::class
    ]
)
interface LapComponent {

    fun createAccountCommandHandler(): CreateAccountCommandHandler

    @Component.Builder
    interface Builder {

        fun build(): LapComponent

    }

}