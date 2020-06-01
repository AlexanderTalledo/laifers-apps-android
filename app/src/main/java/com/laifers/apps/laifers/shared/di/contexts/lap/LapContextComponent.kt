package com.laifers.apps.laifers.shared.di.contexts.lap

import com.laifers.apps.lap.account.application.create.CreateAccountCommandHandler
import dagger.Component

@Component(
    modules = [
        LapApplicationModule::class,
        LapInfrastructureModule::class
    ]
)
interface LapContextComponent {

    fun createAccountCommandHandler(): CreateAccountCommandHandler

    @Component.Builder
    interface Builder {

        fun build(): LapContextComponent

    }

}