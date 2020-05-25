package com.laifers.apps.laifers.signup

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.laifers.apps.laifers.R
import com.laifers.apps.laifers.databinding.ActivitySignupBinding
import com.laifers.apps.laifers.shared.framework.activities.BaseActivity

class SignUpActivity : BaseActivity<ActivitySignupBinding, SignUpViewModel>() {

    override val viewModel by lazy { ViewModelProvider(this).get(SignUpViewModel::class.java) }

    override fun getLayoutId() = R.layout.activity_signup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
    }

}