package com.laifers.apps.laifers.shared.di.core.lap

import com.laifers.apps.core.lap.account.domain.AccountRepository
import com.laifers.apps.core.lap.account.infrastructure.network.AccountRetrofitClient
import com.laifers.apps.core.lap.account.infrastructure.network.RetrofitAccountRepository
import com.laifers.apps.core.lap.account.infrastructure.network.RetrofitAccountService
import dagger.Module
import dagger.Provides

@Module
class LapInfrastructureModule {

    @Provides
    fun provideAccountRepository(
        service: RetrofitAccountService
    ): AccountRepository = RetrofitAccountRepository(service)

    @Provides
    fun provideRetrofitAccountService(
        client: AccountRetrofitClient
    ): RetrofitAccountService = client.retrofit.create(RetrofitAccountService::class.java)

    @Provides
    fun provideAccountRetrofitClient() = AccountRetrofitClient()

}