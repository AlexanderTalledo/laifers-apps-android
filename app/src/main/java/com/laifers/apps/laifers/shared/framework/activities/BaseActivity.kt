package com.laifers.apps.laifers.shared.framework.activities

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel

abstract class BaseActivity<B : ViewDataBinding, V : ViewModel> : AppCompatActivity() {

    private val activity by lazy { this }

    internal lateinit var binding: B

    internal abstract val viewModel: V

    @LayoutRes
    internal abstract fun getLayoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setDataBinding()
    }

    private fun setDataBinding() {
        binding = DataBindingUtil.setContentView(activity, getLayoutId())
        binding.lifecycleOwner = this
    }

}