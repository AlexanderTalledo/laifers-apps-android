package com.laifers.apps.laifers.shared.di.application

import com.laifers.apps.laifers.shared.di.core.CoreComponent
import com.laifers.apps.laifers.LaifersApplication
import com.laifers.apps.laifers.shared.di.application.activities.ActivityBindingModule
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
    dependencies = [CoreComponent::class]
)
interface ApplicationComponent : AndroidInjector<DaggerApplication> {

    override fun inject(instance: DaggerApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: LaifersApplication): Builder

        fun coreComponent(component: CoreComponent)

        fun build(): ApplicationComponent

    }

}