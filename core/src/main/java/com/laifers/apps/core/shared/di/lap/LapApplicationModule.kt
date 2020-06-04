package com.laifers.apps.core.shared.di.lap

import com.laifers.apps.core.lap.account.application.create.AccountCreator
import com.laifers.apps.core.lap.account.application.create.CreateAccountCommandHandler
import com.laifers.apps.core.lap.account.domain.AccountRepository
import dagger.Module
import dagger.Provides

@Module
class LapApplicationModule {

    @Provides
    fun provideCreateAccountCommandHandler(
        creator: AccountCreator
    ) = CreateAccountCommandHandler(creator)

    @Provides
    fun provideAccountCreator(repository: AccountRepository) = AccountCreator(repository)

}