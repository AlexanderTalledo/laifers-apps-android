package com.laifers.apps.laifers

import com.laifers.apps.laifers.shared.di.application.DaggerApplicationComponent
import com.laifers.apps.laifers.shared.di.core.DaggerCoreComponent
import com.laifers.apps.laifers.shared.di.core.lap.DaggerLapComponent
import dagger.android.support.DaggerApplication

class LaifersApplication : DaggerApplication() {

    override fun applicationInjector() = applicationComponent().apply {
        inject(this@LaifersApplication)
    }

    private fun applicationComponent() = with(DaggerApplicationComponent.builder()) {
        application(this@LaifersApplication)
        coreComponent(coreComponent())
        build()
    }

    private fun coreComponent() = with(DaggerCoreComponent.builder()) {
        lapComponent(lapComponent())
        build()
    }

    private fun lapComponent() = DaggerLapComponent.builder().build()

}