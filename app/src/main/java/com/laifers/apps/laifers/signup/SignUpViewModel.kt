package com.laifers.apps.laifers.signup

import android.view.View
import androidx.lifecycle.ViewModel
import com.laifers.apps.lap.account.application.create.CreateAccountCommand
import com.laifers.apps.lap.account.application.create.CreateAccountCommandHandler
import javax.inject.Inject

class SignUpViewModel @Inject constructor(
    private val handler: CreateAccountCommandHandler
) : ViewModel() {

    val form = SignUpForm()

    fun onSignUpButtonClicked(view: View) {
        with(form) {
            handler.handle(CreateAccountCommand(getUsername(), getEmailAddress(), getPassword()))
        }
    }

}