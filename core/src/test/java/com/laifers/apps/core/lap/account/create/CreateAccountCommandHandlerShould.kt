package com.laifers.apps.core.lap.account.create

import com.laifers.apps.core.lap.account.application.create.AccountCreator
import com.laifers.apps.core.lap.account.application.create.CreateAccountCommand
import com.laifers.apps.core.lap.account.application.create.CreateAccountCommandHandler
import com.laifers.apps.core.lap.account.domain.*
import com.laifers.apps.core.lap.account.infrastructure.AccountModuleUnitTestCase
import com.laifers.apps.core.shared.domain.InvalidValue
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import kotlin.reflect.KClass

class CreateAccountCommandHandlerShould : AccountModuleUnitTestCase() {

    private val creator = AccountCreator(repository)
    private val handler = CreateAccountCommandHandler(creator)

    @Nested
    internal inner class Failed {

        @Nested
        internal inner class Input {

            @ParameterizedTest
            @ValueSource(
                strings = [
                    "",
                    " ",
                    "ufa 98a 9 8y asdjf",
                    "25a29306-05e3-44a2-b79b-"
                ]
            )
            fun `when account id value is invalid`(id: String) {
                testInvalidCreateAccountCommand(
                    provideCustomizableCreateAccountCommand(id = id),
                    provideInvalidAccountIdErrorMessage(id)
                )
            }

            @ParameterizedTest
            @ValueSource(
                strings = [
                    "",
                    "   ",
                    "ldf 089fd 90240u9 ga kkkppa",
                    "a",
                    "1",
                    "ab=#$&"
                ]
            )
            fun `when account username value is invalid`(username: String) {
                testInvalidCreateAccountCommand(
                    provideCustomizableCreateAccountCommand(username = username),
                    provideInvalidUsernameErrorMessage(username)
                )
            }

            @ParameterizedTest
            @ValueSource(
                strings = [
                    "",
                    "       ",
                    "fdauhd 8d89sf dasfbhkadbhfadd797 ",
                    "useremail.com",
                    "user@.com",
                    "user@email"
                ]
            )
            fun `when account email address value is invalid`(emailAddress: String) {
                testInvalidCreateAccountCommand(
                    provideCustomizableCreateAccountCommand(emailAddress = emailAddress),
                    provideInvalidEmailAddressErrorMessage(emailAddress)
                )
            }

            @ParameterizedTest
            @ValueSource(
                strings = [
                    "",
                    "        ",
                    "Abc123@",
                    "ABCDefgh!",
                    "abcdefgh@435",
                    "SDFFDUH2343!@",
                    "AOiih9889VDccs",
                    "AOiih9889VDccs?¿"
                ]
            )

            fun `when account password value is invalid`(password: String) {
                testInvalidCreateAccountCommand(
                    provideCustomizableCreateAccountCommand(password = password),
                    provideInvalidPasswordErrorMessage(password)
                )
            }

            private fun testInvalidCreateAccountCommand(
                command: CreateAccountCommand,
                expectedErrorMessage: String
            ) {
                val error = catchThrowable { handleCommand(handler, command) }

                shouldHaveFailed(error, InvalidValue::class, expectedErrorMessage)
            }

            private fun provideCustomizableCreateAccountCommand(
                id: String = AccountIdMother.random().value,
                username: String = AccountUsernameMother.random().value,
                emailAddress: String = AccountEmailAddressMother.random().value,
                password: String = AccountPasswordMother.random().value
            ) = CreateAccountCommandMother.create(id, username, emailAddress, password)

        }

        @Nested
        internal inner class Business {

            @Test
            fun `when tries to create an account with an id that already exists`() {
                val command = provideRandomCreateAccountCommand()
                val account = provideAccount(command)

                with(account) {
                    testBusinessAccountAlreadyExistsError(
                        command,
                        this,
                        AccountIdAlreadyExists(id),
                        AccountIdAlreadyExists::class,
                        "Already exists an account with id: ${id.value}"
                    )
                }
            }

            @Test
            fun `when tries to create an account with a username that already exists`() {
                val command = provideRandomCreateAccountCommand()
                val account = provideAccount(command)

                with(account) {
                    testBusinessAccountAlreadyExistsError(
                        command,
                        this,
                        AccountUsernameAlreadyExists(username),
                        AccountUsernameAlreadyExists::class,
                        "Already exists an account with username: ${username.value}"
                    )
                }
            }

            @Test
            fun `when tries to create an account with an email address that already exists`() {
                val command = provideRandomCreateAccountCommand()
                val account = provideAccount(command)

                with(account) {
                    testBusinessAccountAlreadyExistsError(
                        command,
                        this,
                        AccountEmailAddressAlreadyExists(emailAddress),
                        AccountEmailAddressAlreadyExists::class,
                        "Already exists an account with email address: ${emailAddress.value}"
                    )
                }
            }

            private inline fun <reified A : AccountError> testBusinessAccountAlreadyExistsError(
                command: CreateAccountCommand,
                account: Account,
                expectedError: AccountError,
                expectedErrorKClass: KClass<A>,
                expectedErrorMessage: String
            ) {
                setRepositoryBehaviourCreate(account, expectedError)

                val error = catchThrowable { handleCommand(handler, command) }

                shouldHaveFailed(error, expectedErrorKClass, expectedErrorMessage)
            }

        }

    }

    @Nested
    internal inner class Succeeded {

        @Nested
        internal inner class Business {

            @Test
            fun `creating a new account`() {
                val command = provideRandomCreateAccountCommand()
                val account = provideAccount(command)

                handleCommand(handler, command)

                shouldHaveCreated(account)
            }
        }

    }

    private fun provideRandomCreateAccountCommand() = CreateAccountCommandMother.random()

    private fun provideAccount(command: CreateAccountCommand) = AccountMother.from(command)

}