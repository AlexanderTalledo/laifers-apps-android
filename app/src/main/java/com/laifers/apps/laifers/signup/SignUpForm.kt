package com.laifers.apps.laifers.signup

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.laifers.apps.laifers.BR

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
        notifyPropertyChanged(BR.username)
    }

    @Bindable
    fun getEmailAddress() = emailAddress

    fun setEmailAddress(value: String) {
        if (emailAddress == value) return
        emailAddress = value
        notifyPropertyChanged(BR.emailAddress)
    }

    @Bindable
    fun getPassword() = password

    fun setPassword(value: String) {
        if (password == value) return
        password = value
        notifyPropertyChanged(BR.password)
    }

    @Bindable
    fun getAgreeWith() = agreeWith

    fun setAgreeWith(value: Boolean) {
        if (agreeWith == value) return
        agreeWith = value
        notifyPropertyChanged(BR.agreeWith)
    }

}

