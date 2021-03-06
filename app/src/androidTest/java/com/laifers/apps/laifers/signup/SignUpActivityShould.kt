package com.laifers.apps.laifers.signup

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.laifers.apps.laifers.R
import com.schibsted.spain.barista.assertion.BaristaCheckedAssertions.assertUnchecked
import com.schibsted.spain.barista.assertion.BaristaEnabledAssertions.assertDisabled
import com.schibsted.spain.barista.assertion.BaristaEnabledAssertions.assertEnabled
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertContains
import com.schibsted.spain.barista.interaction.BaristaClickInteractions.clickOn
import com.schibsted.spain.barista.interaction.BaristaEditTextInteractions.writeTo
import com.schibsted.spain.barista.rule.BaristaRule
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class SignUpActivityShould {

    @get:Rule
    var rule = BaristaRule.create(SignUpActivity::class.java)

    @Before
    fun setUp() {
        rule.launchActivity()
    }

    @Test
    fun show_an_edit_text_for_username_field_with_initial_empty_value() {
        assertContains(R.id.etSignUpUsername, "")
    }

    @Test
    fun show_an_edit_text_for_email_address_field_with_initial_empty_value() {
        assertContains(R.id.etSignUpEmailAddress, "")
    }

    @Test
    fun show_an_edit_text_for_password_field_with_initial_empty_value() {
        assertContains(R.id.etSignUpPassword, "")
    }

    @Test
    fun show_an_edit_text_for_password_confirmation_field_with_initial_empty_value() {
        assertContains(R.id.etSignUpPassword, "")
    }

    @Test
    fun show_a_check_box_for_agree_terms_with_initial_not_accepted_value() {
        assertUnchecked(R.id.cbSignUpTerms)
    }

    @Test
    fun show_sign_up_button_with_correct_initial_text() {
        assertContains("Register")
    }

    @Test
    fun show_sign_up_button_initially_disabled() {
        assertDisabled(R.id.btnSignUp)
    }

    @Test
    fun keep_sign_up_button_disabled_when_username_field_is_not_correctly_filled() {
        fillSignUpForm(username = "")

        assertDisabled(R.id.btnSignUp)
    }

    @Test
    fun keep_sign_up_button_disabled_when_email_address_field_is_not_correctly_filled() {
        fillSignUpForm(emailAddress = "")

        assertDisabled(R.id.btnSignUp)
    }

    @Test
    fun keep_sign_up_button_disabled_when_password_field_is_not_correctly_filled() {
        fillSignUpForm(password = "")

        assertDisabled(R.id.btnSignUp)
    }

    @Test
    fun keep_sign_up_button_disabled_when_password_confirmation_field_is_not_correctly_filled() {
        fillSignUpForm(passwordConfirmation = "")

        assertDisabled(R.id.btnSignUp)
    }

    @Test
    fun keep_sign_up_button_disabled_when_terms_are_not_accepted() {
        fillSignUpForm(isAgreeWithTerms = false)

        assertDisabled(R.id.btnSignUp)
    }

    @Test
    fun enable_sign_up_button_when_form_is_correctly_filled() {
        fillSignUpForm()

        assertEnabled(R.id.btnSignUp)
    }

    private fun fillSignUpForm(
        username: String = "user",
        emailAddress: String = "user@email.io",
        password: String = "User1234@",
        passwordConfirmation: String = "User1234@",
        isAgreeWithTerms: Boolean = true
    ) {
        writeTo(R.id.etSignUpUsername, username)
        writeTo(R.id.etSignUpEmailAddress, emailAddress)
        writeTo(R.id.etSignUpPassword, password)
        writeTo(R.id.etSignUpPasswordConfirmation, passwordConfirmation)
        if (isAgreeWithTerms) clickOn(R.id.cbSignUpTerms)
    }

}