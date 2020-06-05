package com.laifers.apps.core.lap.account.infrastructure

import com.laifers.apps.core.lap.account.domain.*
import com.laifers.apps.core.shared.infrastructure.UnitTestCase
import io.mockk.clearMocks
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach

private const val EXPECTED_TIMES_DEFAULT_CREATE = 1

abstract class AccountModuleUnitTestCase : UnitTestCase() {

    internal val repository = mockk<AccountRepository>(relaxUnitFun = true)

    @BeforeEach
    fun setUp() {
        clearMocks(repository)
    }

    internal fun provideInvalidAccountIdErrorMessage(id: String) =
        provideInvalidValueErrorMessage(AccountId::class, id)

    internal fun provideInvalidUsernameErrorMessage(username: String) =
        provideInvalidValueErrorMessage(AccountUsername::class, username)

    internal fun provideInvalidEmailAddressErrorMessage(emailAddress: String) =
        provideInvalidValueErrorMessage(AccountEmailAddress::class, emailAddress)

    internal fun provideInvalidPasswordErrorMessage(password: String) =
        provideInvalidValueErrorMessage(AccountPassword::class, password)

    internal fun setRepositoryBehaviourCreate(account: Account, error: AccountError) {
        every { repository.create(account) } throws error
    }

    internal fun shouldHaveCreated(
        account: Account,
        expectedTimes: Int = EXPECTED_TIMES_DEFAULT_CREATE
    ) {
        verify(exactly = expectedTimes) { repository.create(account) }
    }

}