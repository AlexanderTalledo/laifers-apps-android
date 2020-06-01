package com.laifers.apps.laifers.shared.di.activities

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.laifers.apps.laifers.shared.framework.lifecycle.BaseViewModelFactory
import com.laifers.apps.laifers.signup.SignUpViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ActivityViewModelModule {

    @Binds
    @ActivityScoped
    @ActivityViewModelFactory
    internal abstract fun bindActivityViewModelFactory(
        viewModelFactory: BaseViewModelFactory
    ): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ActivityViewModelKey(SignUpViewModel::class)
    internal abstract fun bindSignUpViewModel(viewModel: SignUpViewModel): ViewModel

}