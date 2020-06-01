package com.laifers.apps.laifers.signup

import android.view.View
import androidx.lifecycle.ViewModel
import com.laifers.apps.lap.account.application.create.AccountCreator
import com.laifers.apps.lap.account.application.create.CreateAccountCommand
import com.laifers.apps.lap.account.application.create.CreateAccountCommandHandler
import com.laifers.apps.lap.account.infrastructure.network.RetrofitAccountRepository
import javax.inject.Inject

class SignUpViewModel @Inject constructor() : ViewModel() {

    val form = SignUpForm()

    private val creator by lazy { AccountCreator(RetrofitAccountRepository()) }
    private val handler by lazy { CreateAccountCommandHandler(creator) }

    fun onSignUpButtonClicked(view: View) {
        with(form) {
            handler.handle(CreateAccountCommand(getUsername(), getEmailAddress(), getPassword()))
        }
    }

}