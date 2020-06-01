package com.laifers.apps.laifers.shared.di.application

import com.laifers.apps.laifers.LaifersApplication
import com.laifers.apps.laifers.shared.di.activities.ActivityBindingModule
import com.laifers.apps.laifers.shared.di.contexts.lap.LapContextComponent
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication

@ApplicationScoped
@Component(
    modules = [
        ActivityBindingModule::class,
        AndroidSupportInjectionModule::class,
        ApplicationModule::class
    ],
    dependencies = [LapContextComponent::class]
)
interface ApplicationComponent : AndroidInjector<DaggerApplication> {

    override fun inject(instance: DaggerApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: LaifersApplication): Builder

        fun lapContextComponent(component: LapContextComponent): Builder

        fun build(): ApplicationComponent

    }

}