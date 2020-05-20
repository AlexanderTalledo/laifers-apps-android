package com.laifers.apps.laifers.signup

import androidx.lifecycle.ViewModel
import com.laifers.apps.lap.account.application.create.AccountCreator
import com.laifers.apps.lap.account.application.create.CreateAccountCommand
import com.laifers.apps.lap.account.application.create.CreateAccountCommandHandler
import com.laifers.apps.lap.account.infrastructure.network.RetrofitAccountRepository

class SignUpViewModel : ViewModel() {

    private val creator by lazy { AccountCreator(RetrofitAccountRepository()) }
    private val handler by lazy { CreateAccountCommandHandler(creator) }

    fun onSignUpButtonClicked(username: String, emailAddress: String, password: String) {
        handler.handle(CreateAccountCommand(username, emailAddress, password))
    }


}