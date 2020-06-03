package com.laifers.apps.laifers.signup

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.laifers.apps.lap.account.application.create.CreateAccountCommand
import com.laifers.apps.lap.account.application.create.CreateAccountCommandHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SignUpViewModel @Inject constructor(
    private val handler: CreateAccountCommandHandler
) : ViewModel() {

    val form = SignUpForm()

    fun onSignUpButtonClicked(view: View) {
        signUp()
    }

    private fun signUp() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                with(form) {
                    handler.handle(
                        CreateAccountCommand(
                            username = getUsername(),
                            emailAddress = getEmailAddress(),
                            password = getPassword()
                        )
                    )
                }
            }
        }
    }

}