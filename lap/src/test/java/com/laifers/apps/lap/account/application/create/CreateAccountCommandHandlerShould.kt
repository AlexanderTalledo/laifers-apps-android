package com.laifers.apps.lap.account.application.create

import com.laifers.apps.lap.account.domain.AccountEmailAddressMother
import com.laifers.apps.lap.account.domain.AccountIdMother
import com.laifers.apps.lap.account.domain.AccountPasswordMother
import com.laifers.apps.lap.account.domain.AccountUsernameMother
import com.laifers.apps.lap.account.infrastructure.AccountModuleUnitTestCase
import com.laifers.apps.shared.domain.InvalidValue
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class CreateAccountCommandHandlerShould : AccountModuleUnitTestCase() {

    private val creator = AccountCreator(repository)
    private val handler = CreateAccountCommandHandler(creator)

    @Nested
    internal inner class Failed {

        @Nested
        internal inner class Input {

            @Test
            fun `when account id input value is empty`() {
                val id = ""

                testInvalidCreateAccountCommand(
                    provideCustomizableCreateAccountCommand(id = id),
                    provideInvalidAccountIdErrorMessage(id)
                )
            }

            @Test
            fun `when account id input value is whitespaces only`() {
                val id = "    "

                testInvalidCreateAccountCommand(
                    provideCustomizableCreateAccountCommand(id = id),
                    provideInvalidAccountIdErrorMessage(id)
                )
            }

            @Test
            fun `when account id input value is a random text`() {
                val id = "adf98d dafhiadsf9y adsf9yasydsaf joh9u"

                testInvalidCreateAccountCommand(
                    provideCustomizableCreateAccountCommand(id = id),
                    provideInvalidAccountIdErrorMessage(id)
                )
            }

            @Test
            fun `when account id input value is an incomplete id`() {
                val id = "25a29306-05e3-44a2-b79b-"

                testInvalidCreateAccountCommand(
                    provideCustomizableCreateAccountCommand(id = id),
                    provideInvalidAccountIdErrorMessage(id)
                )
            }

            @Test
            fun `when account username input value is empty`() {
                val username = ""

                testInvalidCreateAccountCommand(
                    provideCustomizableCreateAccountCommand(username = username),
                    provideInvalidUsernameErrorMessage(username)
                )
            }

            @Test
            fun `when account username input value is whitespaces only`() {
                val username = "     "

                testInvalidCreateAccountCommand(
                    provideCustomizableCreateAccountCommand(username = username),
                    provideInvalidUsernameErrorMessage(username)
                )
            }

            @Test
            fun `when account username input value is a random text`() {
                val username = "ldf 089fd 90240u9 ga kkkppa"

                testInvalidCreateAccountCommand(
                    provideCustomizableCreateAccountCommand(username = username),
                    provideInvalidUsernameErrorMessage(username)
                )
            }

            @Test
            fun `when account username input value has no minimum required length`() {
                val username = "ab"

                testInvalidCreateAccountCommand(
                    provideCustomizableCreateAccountCommand(username = username),
                    provideInvalidUsernameErrorMessage(username)
                )
            }

            @Test
            fun `when account username input value contains not allowed special characters`() {
                val username = "ab=#$&"

                testInvalidCreateAccountCommand(
                    provideCustomizableCreateAccountCommand(username = username),
                    provideInvalidUsernameErrorMessage(username)
                )
            }

            @Test
            fun `when account email address input value is empty`() {
                val emailAddress = ""

                testInvalidCreateAccountCommand(
                    provideCustomizableCreateAccountCommand(emailAddress = emailAddress),
                    provideInvalidEmailAddressErrorMessage(emailAddress)
                )
            }

            @Test
            fun `when account email address input value is whitespaces only`() {
                val emailAddress = "       "

                testInvalidCreateAccountCommand(
                    provideCustomizableCreateAccountCommand(emailAddress = emailAddress),
                    provideInvalidEmailAddressErrorMessage(emailAddress)
                )
            }

            @Test
            fun `when account email address input value is a random text`() {
                val emailAddress = "fdauhd 8d89sf dasfbhkadbhfadd797 "

                testInvalidCreateAccountCommand(
                    provideCustomizableCreateAccountCommand(emailAddress = emailAddress),
                    provideInvalidEmailAddressErrorMessage(emailAddress)
                )
            }

            @Test
            fun `when account email address input value has not an @ symbol`() {
                val emailAddress = "useremail.com "

                testInvalidCreateAccountCommand(
                    provideCustomizableCreateAccountCommand(emailAddress = emailAddress),
                    provideInvalidEmailAddressErrorMessage(emailAddress)
                )
            }

            @Test
            fun `when account email address input value has no server name`() {
                val emailAddress = "user@.com "

                testInvalidCreateAccountCommand(
                    provideCustomizableCreateAccountCommand(emailAddress = emailAddress),
                    provideInvalidEmailAddressErrorMessage(emailAddress)
                )
            }

            @Test
            fun `when account email address input value has no domain`() {
                val emailAddress = "user@email"

                testInvalidCreateAccountCommand(
                    provideCustomizableCreateAccountCommand(emailAddress = emailAddress),
                    provideInvalidEmailAddressErrorMessage(emailAddress)
                )
            }

            @Test
            fun `when account password input value is empty`() {
                val password = ""

                testInvalidCreateAccountCommand(
                    provideCustomizableCreateAccountCommand(password = password),
                    provideInvalidPasswordErrorMessage(password)
                )
            }

            @Test
            fun `when account password input value is whitespaces only`() {
                val password = "        "

                testInvalidCreateAccountCommand(
                    provideCustomizableCreateAccountCommand(password = password),
                    provideInvalidPasswordErrorMessage(password)
                )
            }

            @Test
            fun `when account password has no minimum required length`() {
                val password = "Abc123@"

                testInvalidCreateAccountCommand(
                    provideCustomizableCreateAccountCommand(password = password),
                    provideInvalidPasswordErrorMessage(password)
                )
            }

            @Test
            fun `when account password has no required at least one number`() {
                val password = "ABCDefgh!"

                testInvalidCreateAccountCommand(
                    provideCustomizableCreateAccountCommand(password = password),
                    provideInvalidPasswordErrorMessage(password)
                )
            }

            @Test
            fun `when account password has no required at least one uppercase character`() {
                val password = "abcdefgh@435"

                testInvalidCreateAccountCommand(
                    provideCustomizableCreateAccountCommand(password = password),
                    provideInvalidPasswordErrorMessage(password)
                )
            }

            @Test
            fun `when account password has no required at least one lowercase character`() {
                val password = "SDFFDUH2343!@"

                testInvalidCreateAccountCommand(
                    provideCustomizableCreateAccountCommand(password = password),
                    provideInvalidPasswordErrorMessage(password)
                )
            }

            @Test
            fun `when account password has no required at least one special character`() {
                val password = "AOiih9889VDccs"

                testInvalidCreateAccountCommand(
                    provideCustomizableCreateAccountCommand(password = password),
                    provideInvalidPasswordErrorMessage(password)
                )
            }

            @Test
            fun `when account password has not allowed special characters`() {
                val password = "AOiih9889VDccs?¿"

                testInvalidCreateAccountCommand(
                    provideCustomizableCreateAccountCommand(password = password),
                    provideInvalidPasswordErrorMessage(password)
                )
            }

            private fun testInvalidCreateAccountCommand(command: CreateAccountCommand, expectedErrorMessage: String) {
                val error = catchThrowable { handleCommand(handler, command) }

                shouldHaveFailed(error, InvalidValue::class, expectedErrorMessage)
            }

            private fun provideCustomizableCreateAccountCommand(
                id: String = AccountIdMother.random().value,
                username: String = AccountUsernameMother.random().value,
                emailAddress: String = AccountEmailAddressMother.random().value,
                password: String = AccountPasswordMother.random().value
            ) = CreateAccountCommandMother.create(
                id,
                username,
                emailAddress,
                password
            )

        }

    }

}