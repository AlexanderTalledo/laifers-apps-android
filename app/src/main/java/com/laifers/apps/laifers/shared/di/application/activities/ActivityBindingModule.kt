package com.laifers.apps.laifers.shared.di.application.activities

import com.laifers.apps.laifers.signup.SignUpActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [ActivityViewModelModule::class])
    internal abstract fun bindSignUpActivity(): SignUpActivity

}