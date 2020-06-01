package com.laifers.apps.laifers

import com.laifers.apps.laifers.shared.di.application.DaggerApplicationComponent
import com.laifers.apps.laifers.shared.di.lap.DaggerLapComponent
import dagger.android.support.DaggerApplication

class LaifersApplication : DaggerApplication() {

    override fun applicationInjector() = applicationComponent().apply {
        inject(this@LaifersApplication)
    }

    private fun applicationComponent() = with(DaggerApplicationComponent.builder()) {
        lapComponent(lapComponent())
        application(this@LaifersApplication)
        build()
    }

    private fun lapComponent() = DaggerLapComponent.builder().build()

}