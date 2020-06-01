package com.laifers.apps.laifers.shared.di.contexts.lap

import com.laifers.apps.lap.account.domain.AccountRepository
import dagger.Component

@Component(modules = [LapRepositoriesModule::class])
interface LapContextComponent {

    fun getAccountRepository(): AccountRepository

    @Component.Builder
    interface Builder {

        fun build(): LapContextComponent

    }

}