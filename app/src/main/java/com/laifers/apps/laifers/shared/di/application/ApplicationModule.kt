package com.laifers.apps.laifers.shared.di.application

import android.content.Context
import com.laifers.apps.laifers.LaifersApplication
import dagger.Binds
import dagger.Module

@Module
abstract class ApplicationModule {

    @Binds
    @ApplicationContext
    internal abstract fun bindApplicationContext(laifersApplication: LaifersApplication): Context

}