package com.laifers.apps.laifers.signup

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.laifers.apps.laifers.BR
import com.laifers.apps.lap.account.domain.AccountEmailAddress
import com.laifers.apps.lap.account.domain.AccountPassword
import com.laifers.apps.lap.account.domain.AccountUsername
import com.laifers.apps.shared.domain.InvalidValue

class SignUpForm : BaseObservable() {

    private var username: String = ""
    private var emailAddress: String = ""
    private var password: String = ""
    private var agreeWith: Boolean = false

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
    fun getAgreeWith() = agreeWith

    fun setAgreeWith(value: Boolean) {
        if (agreeWith == value) return
        agreeWith = value
        notifyPropertyChanged(BR.isFilledCorrectly)
    }

    @Bindable
    fun getIsFilledCorrectly(): Boolean {
        return isUsernameFilledCorrectly() &&
                isEmailAddressFilledCorrectly() &&
                isPasswordFilledCorrectly() &&
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

    private fun isAgreeWithFilledCorrectly() = agreeWith

}

