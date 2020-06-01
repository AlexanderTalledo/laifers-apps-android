package com.laifers.apps.laifers.shared.di.contexts.lap

import com.laifers.apps.lap.account.domain.AccountRepository
import com.laifers.apps.lap.account.infrastructure.network.RetrofitAccountRepository
import dagger.Module
import dagger.Provides

@Module
class LapRepositoriesModule {

    @Provides
    fun provideAccountRepository(): AccountRepository = RetrofitAccountRepository()

}