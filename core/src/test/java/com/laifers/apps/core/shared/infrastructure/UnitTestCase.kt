package com.laifers.apps.core.shared.infrastructure

import com.laifers.apps.core.shared.domain.DomainError
import com.laifers.apps.core.shared.domain.bus.commands.Command
import com.laifers.apps.core.shared.domain.bus.commands.CommandHandler
import com.laifers.apps.core.shared.domain.valueobjects.StringValueObject
import org.assertj.core.api.Assertions.assertThat
import kotlin.reflect.KClass

abstract class UnitTestCase {

    inline fun <reified C : Command> handleCommand(handler: CommandHandler<C>, command: C) {
        handler.handle(command)
    }

    inline fun <reified E : DomainError> shouldHaveFailed(
        error: Throwable,
        expectedErrorKClass: KClass<E>,
        expectedErrorMessage: String
    ) {
        assertThat(error)
            .isExactlyInstanceOf(expectedErrorKClass.java)
            .hasMessage(expectedErrorMessage)
    }

    inline fun <reified V : StringValueObject> provideInvalidValueErrorMessage(
        kClass: KClass<V>,
        value: String
    ) = valueErrorMessage(kClass.simpleName, value)

    fun valueErrorMessage(className: String?, value: String) = "Invalid $className value: $value"

}