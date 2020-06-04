package com.laifers.apps.laifers.shared.framework.activities

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.lifecycle.ViewModel
import com.laifers.apps.laifers.shared.di.application.activities.ActivityViewModelFactory
import com.laifers.apps.laifers.shared.framework.lifecycle.BaseViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity<V : ViewModel> : DaggerAppCompatActivity() {

    @Inject
    @ActivityViewModelFactory
    lateinit var viewModelFactory: BaseViewModelFactory

    internal val activity by lazy { this }

    internal abstract val viewModel: V

    @LayoutRes
    internal abstract fun getLayoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
    }

}