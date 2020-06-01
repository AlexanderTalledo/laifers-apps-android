package com.laifers.apps.laifers.shared.framework.activities

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel

abstract class BaseBindingActivity<B : ViewDataBinding, V : ViewModel> : BaseActivity<V>() {

    internal lateinit var binding: B

    internal abstract fun setBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(activity, getLayoutId())
        setBinding()
    }

}