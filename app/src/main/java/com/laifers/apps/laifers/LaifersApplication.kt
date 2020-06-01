package com.laifers.apps.laifers

import com.laifers.apps.laifers.shared.di.application.DaggerApplicationComponent
import com.laifers.apps.laifers.shared.di.contexts.lap.DaggerLapContextComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class LaifersApplication : DaggerApplication() {

    private val laifersApplication by lazy { this }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val applicationComponent = getApplicationComponent()
        applicationComponent.inject(laifersApplication)
        return applicationComponent
    }

    private fun getApplicationComponent() = with(DaggerApplicationComponent.builder()) {
        lapContextComponent(getLapContextComponent())
        application(laifersApplication)
        build()
    }

    private fun getLapContextComponent() = DaggerLapContextComponent.builder().build()

}