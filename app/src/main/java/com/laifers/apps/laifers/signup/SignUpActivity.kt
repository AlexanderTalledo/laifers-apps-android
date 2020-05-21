package com.laifers.apps.laifers.signup

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.laifers.apps.laifers.R
import com.laifers.apps.laifers.databinding.ActivitySignupBinding

class SignUpActivity : AppCompatActivity() {

    private val viewModel by lazy { ViewModelProvider(this).get(SignUpViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        val binding = DataBindingUtil
            .setContentView<ActivitySignupBinding>(this, R.layout.activity_signup)
        binding.viewModel = viewModel
    }

}