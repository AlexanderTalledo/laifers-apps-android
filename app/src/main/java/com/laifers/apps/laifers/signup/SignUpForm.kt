package com.laifers.apps.laifers.signup

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.laifers.apps.laifers.BR
import com.laifers.apps.lap.account.domain.AccountEmailAddress
import com.laifers.apps.lap.account.domain.AccountPassword
import com.laifers.apps.lap.account.domain.AccountUsername
import com.laifers.apps.shared.constants.Character.EMPTY
import com.laifers.apps.shared.domain.InvalidValue

class SignUpForm : BaseObservable() {

    private var username: String = EMPTY
    private var emailAddress: String = EMPTY
    private var password: String = EMPTY
    private var passwordConfirmation: String = EMPTY
    private var isAgreeWithTerms: Boolean = false

    @Bindable
    fun getUsername() = username

    fun setUsername(value: String) {
        if (username == value) return
        username = value
        notifyPropertyChanged(BR.isFilledCorrectly)
    }

    @Bindable
    fun getEmailAddress() = emailAddress

    fun setEmailAddress(value: String) {
        if (emailAddress == value) return
        emailAddress = value
        notifyPropertyChanged(BR.isFilledCorrectly)
    }

    @Bindable
    fun getPassword() = password

    fun setPassword(value: String) {
        if (password == value) return
        password = value
        notifyPropertyChanged(BR.isFilledCorrectly)
    }

    @Bindable
    fun getPasswordConfirmation() = passwordConfirmation

    fun setPasswordConfirmation(value: String) {
        if (passwordConfirmation == value) return
        passwordConfirmation = value
        notifyPropertyChanged(BR.isFilledCorrectly)
    }

    @Bindable
    fun getIsAgreeWithTerms() = isAgreeWithTerms

    fun setIsAgreeWithTerms(value: Boolean) {
        if (isAgreeWithTerms == value) return
        isAgreeWithTerms = value
        notifyPropertyChanged(BR.isFilledCorrectly)
    }

    @Bindable
    fun getIsFilledCorrectly(): Boolean {
        return isUsernameFilledCorrectly() &&
                isEmailAddressFilledCorrectly() &&
                isPasswordFilledCorrectly() &&
                isPasswordConfirmationFilledCorrectly() &&
                isAgreeWithFilledCorrectly()
    }

    private fun isUsernameFilledCorrectly() = try {
        AccountUsername(username)
        true
    } catch (_: InvalidValue) {
        false
    }

    private fun isEmailAddressFilledCorrectly() = try {
        AccountEmailAddress(emailAddress)
        true
    } catch (_: InvalidValue) {
        false
    }

    private fun isPasswordFilledCorrectly() = try {
        AccountPassword(password)
        true
    } catch (_: InvalidValue) {
        false
    }

    private fun isPasswordConfirmationFilledCorrectly() = passwordConfirmation == password

    private fun isAgreeWithFilledCorrectly() = isAgreeWithTerms

}

