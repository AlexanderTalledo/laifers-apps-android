package com.laifers.apps.laifers.shared.framework.activities

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel

abstract class BaseActivity<V : ViewModel> : AppCompatActivity() {

    internal val activity by lazy { this }

    internal abstract val viewModel: V

    @LayoutRes
    internal abstract fun getLayoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
    }

}