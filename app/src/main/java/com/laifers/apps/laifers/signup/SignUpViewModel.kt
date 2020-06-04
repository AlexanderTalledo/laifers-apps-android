package com.laifers.apps.laifers.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.laifers.apps.core.lap.account.application.create.CreateAccountCommand
import com.laifers.apps.core.shared.domain.bus.commands.CommandBus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SignUpViewModel @Inject constructor(private val commandBus: CommandBus) : ViewModel() {

    val form = SignUpForm()

    fun onSignUpButtonClicked() {
        signUp()
    }

    private fun signUp() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                with(form) {
                    commandBus.dispatch(
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