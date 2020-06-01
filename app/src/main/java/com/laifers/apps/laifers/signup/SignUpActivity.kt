package com.laifers.apps.laifers.signup

import androidx.lifecycle.ViewModelProvider
import com.laifers.apps.laifers.R
import com.laifers.apps.laifers.databinding.ActivitySignupBinding
import com.laifers.apps.laifers.shared.framework.activities.BaseBindingActivity

class SignUpActivity : BaseBindingActivity<ActivitySignupBinding, SignUpViewModel>() {

    override val viewModel by lazy { ViewModelProvider(this).get(SignUpViewModel::class.java) }

    override fun getLayoutId() = R.layout.activity_signup

    override fun setBinding() {
        with(binding) {
            this.viewModel = this@SignUpActivity.viewModel
            lifecycleOwner = this@SignUpActivity
        }
    }

}