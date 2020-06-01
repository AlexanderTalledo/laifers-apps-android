package com.laifers.apps.laifers.shared.di.activities

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

@MapKey
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityViewModelKey(val value: KClass<out ViewModel>)
