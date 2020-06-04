package com.laifers.apps.laifers.shared.di.core

import com.laifers.apps.core.shared.domain.bus.commands.Command
import dagger.MapKey
import kotlin.reflect.KClass

@MapKey
@Retention(AnnotationRetention.RUNTIME)
annotation class CoreCommandHandlerKey(val value: KClass<out Command>)